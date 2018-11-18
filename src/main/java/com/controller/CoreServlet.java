package com.controller;

import com.entites.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.MessageUtil;
import com.message.entity.BaseMessage;
import com.message.entity.LocationMessage;
import com.message.entity.TextMessage;
import com.message.response.TextMessageResponse;
import com.myaop.UserDataJoinPoint;
import com.service.AccountClient;
import com.service.CouponClient;
import com.service.UserClient;
import com.util.*;
import com.custommessage.CustomMsgSender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by huyoucheng on 2017/5/26.
 */
@RestController
public class CoreServlet {

    static Logger logger = Logger.getLogger(CoreServlet.class);

    private String controllerName = "CoreServlet";

    @Autowired
    CouponClient couponClient;

    @Autowired
    BaiduUtil baiduUtil;

    @Value("${subscribeRespContent}")
    String subscribeRespContent;



    @Value("${pageDomain}")
    String pageDomain;


    @RequestMapping(value = "/servlet/CoreServlet",method = RequestMethod.GET)
    public String coreServletGet(HttpServletRequest request,HttpServletResponse response){
        //接受微信服务器传来的四个参数
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");
        if(ValidateWeixin.checkSignature(signature, timestamp, nonce)){
            return echostr;
        }else {
            logger.info("握手验证失败");
            return "";
        }
    }

    @RequestMapping(value = "/servlet/CoreServlet",method = RequestMethod.POST)
    public String coreServletPost(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e);
        }
        Map<String,String> map = MessageUtil.parseXml(request);
        logger.info("收到微信消息-->["+map.get("fromUserName")+"]:("+map+")");
        String toUserXml = this.analyseMessage(map);
        toUserXml = toUserXml.replace("<TextMessageResponse xmlns=\"\">","<xml>")
                .replace("</TextMessageResponse>","</xml>")
                .replace("<ImageMessageResponse xmlns=\"\">", "<xml>")
                .replace("</ImageMessageResponse>","</xml>");
        logger.info("回复微信:("+toUserXml+")");
        return toUserXml;
    }


    /*
    * 分发消息
    * */
    public String analyseMessage(Map<String,String> map){
        String toUserBaseMessageXml = "";//回复用户的message,空字符串的话微信那边不会显示‘该公众号不能提供服务’的字样

        BaseMessage fromBaseMessage = new BaseMessage();//收到用户的message

        String msgType = map.get("msgType").trim();//消息类型
        String fromUserName = map.get("fromUserName").trim();//消息来源
        String toUserName = map.get("toUserName").trim();//消息来源

        fromBaseMessage.setFromUserName(fromUserName);
        fromBaseMessage.setToUserName(toUserName);
        fromBaseMessage.setMsgType(msgType);

        if(msgType.equalsIgnoreCase("text")){//文本消息

            TextMessage textMessage = MyObject.toBean(MyObject.mapToJsonStr(map), TextMessage.class);
            fromBaseMessage = textMessage;
            toUserBaseMessageXml = TextMessageResponse.buildMessageResponse(fromBaseMessage,this.buildTextMessage(textMessage));

        }else if(msgType.equalsIgnoreCase("location")) {//定位消息

            LocationMessage locationMessage = MyObject.toBean(MyObject.mapToJsonStr(map),LocationMessage.class);
            fromBaseMessage = locationMessage;

        }else if(msgType.equalsIgnoreCase("event")){//事件消息

            String eventName = map.get("event").trim();
            String enventParam = map.get("eventKey");
            if(eventName.equalsIgnoreCase("subscribe")){//关注事件
                toUserBaseMessageXml = TextMessageResponse.buildMessageResponse(fromUserName,toUserName,subscribeRespContent);
                if (enventParam!=null && enventParam.length()>0){//扫描代参二维码(关注)
                    enventParam = enventParam.split("_")[1];
                    fromUserName += "~~~"+enventParam;
                }
                subscribeEvent(fromUserName);
                if (fromUserName.contains("~~~")){
                    scanParamQRCodeEvent(enventParam);
                }
            }else if(eventName.equalsIgnoreCase("unsubscribe")){
                logger.info("用户["+fromUserName+"]取消了关注");
            }else if(eventName.equalsIgnoreCase("scan")){//关注了的用户扫描二维码
                if (enventParam!=null && enventParam.length()>0){
                }
            }else if(eventName.equalsIgnoreCase("location")){//上报位置事件
                LocationMessage locationMessage = MyObject.toBean(MyObject.mapToJsonStr(map),LocationMessage.class);
                fromBaseMessage = locationMessage;
                DetailAddress address =  uploadLocationEvent(fromUserName,locationMessage);
//                toUserBaseMessageXml = TextMessageResponse.buildMessageResponse(fromUserName,
//                        toUserName,address.getFormatted_address());
            }else if(eventName.equalsIgnoreCase("click")){//点击菜单按钮事件
                toUserBaseMessageXml = TextMessageResponse.buildMessageResponse(fromUserName,
                        toUserName,
                        this.clickEvent(fromUserName,enventParam));
            }

        }else {//其他类型消息

        }
        return toUserBaseMessageXml;
    }

    @Autowired
    UserDataJoinPoint userDataJoinPoint;

    //关注事件
    @RequestMapping(value = "/subscribeEvent")
    public void subscribeEvent(String fromUserName){
        userDataJoinPoint.dealUserData(fromUserName, null);
    }

    //扫描带参二维码事件
    private void scanParamQRCodeEvent(String qrcodeParam){
        System.out.println("scanParamQRCodeEvent:"+qrcodeParam);
        new Thread(() -> {
            SimpleResponseBody<Order> orderSimpleResponseBody = couponClient.giveCoupons(Integer.parseInt(qrcodeParam));
            System.out.println(orderSimpleResponseBody);
        }).start();
    }

    //上报地理位置事件
    private DetailAddress uploadLocationEvent(String fromUserName,LocationMessage locationMessage){
        DetailAddress adress = baiduUtil.getDetailAddressByLatLng(locationMessage.getLatitude(), locationMessage.getLongitude());
        userDataJoinPoint.dealUserData(fromUserName, adress);
        return adress;
    }

    @Autowired
    QrCodeController qrCodeController;
    //点击按钮事件
    private String clickEvent(String fromUserName,String key){
        if (key.equalsIgnoreCase("CONTACT_US")){
            return "电话：18723229138";
        }else if(key.equalsIgnoreCase("PRODUCT_INTRODUCTION")){
            return subscribeRespContent;
        }else if (key.equalsIgnoreCase("INVITE_FRIENDS")){
            UserData userData = userDataJoinPoint.dealUserData(fromUserName,null);
            if (userData.getId() > 0) {
                QrResp qrResp = qrCodeController.getQrTicket((int)userData.getId());
                String qrCodeImageUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+qrResp.getTicket();
                qrCodeImageUrl = pageDomain + "/qrcode.html?imgUrl=" + URLEncoder.encode(qrCodeImageUrl);
                return "<a href='"+ qrCodeImageUrl +"'>点我展示二维码</a>";
            }
        }
        return "";
    }


    /*
    * 根据用户发送的文字内容构建回复消息
    * */
    @Value("${keyWords}")
    String keyWords;
    public String buildTextMessage(TextMessage textMessage){
//        String userContent = textMessage.getContent();//用户输入的文字
//        String respContent = defaultRespContent;
//        if (ActivityUtil.isHaveKeyWordActivity()){
//            if (Arrays.asList(keyWords.split("_")).contains(userContent)){
//                respContent = keyWordActivityRespContent;
//            }
//        }
//        return respContent;
        return subscribeRespContent;
    }

    /*
    * 根据关注回复消息
    * */
    public String buildTextMessageForSubscribe(){
        String respContent = subscribeRespContent;
        return respContent;
    }



    @RequestMapping(value = "/time/now",produces = "application/json;charset=utf-8")
    public Result noewTime(HttpServletRequest request){
        return new Result(0,"success", TimeConvert.convertTimeStamp("YYYY-MM-dd hh:mm:ss"));
    }
}
