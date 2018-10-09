package com.controller;

import com.entites.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jedis.JedisUtil;
import com.message.MessageUtil;
import com.message.entity.BaseMessage;
import com.message.entity.LocationMessage;
import com.message.entity.TextMessage;
import com.message.response.TextMessageResponse;
import com.util.TimeConvert;
import com.util.ValidateWeixin;
import custom.message.CustomMsgSender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by huyoucheng on 2017/5/26.
 */
@RestController
public class CoreServlet {

    static Logger logger = Logger.getLogger(CoreServlet.class);

    private String controllerName = "CoreServlet";

    ObjectMapper mapper = new ObjectMapper();

    @Value("${subscribeRespContent}")
    String subscribeRespContent;


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
                //新用户只要关注就赠送天棒

                if (enventParam!=null && enventParam.length()>0){//扫描代参二维码(关注)

                }

            }else if(eventName.equalsIgnoreCase("unsubscribe")){
                logger.info("用户["+fromUserName+"]取消了关注");
            }else if(eventName.equalsIgnoreCase("scan")){//关注了的用户扫描二维码
                if (enventParam!=null && enventParam.length()>0){

                }
            }else if(eventName.equalsIgnoreCase("location")){//上报位置事件
                LocationMessage locationMessage = MyObject.toBean(MyObject.mapToJsonStr(map),LocationMessage.class);
                fromBaseMessage = locationMessage;
            }else if(eventName.equalsIgnoreCase("click")){//点击菜单按钮事件
                toUserBaseMessageXml = TextMessageResponse.buildMessageResponse(fromUserName,
                        toUserName,
                        this.clickEvent(enventParam));
            }

        }else {//其他类型消息

        }
        return toUserBaseMessageXml;
    }

    public String clickEvent(String key){
        if (key.equalsIgnoreCase("CONTACT_US")){
            return "电话：18723229138";
        }else if(key.equalsIgnoreCase("PRODUCT_INTRODUCTION")){
            return subscribeRespContent;
        }
        return "";
    }


//    //fromEvent事件来源，0表示关注事件，1表示扫描事件
//    //scanParam扫描参数，也可以是其他的自定义参数，比如新用户关注
//    public void asyncGiveCoupons(final BaseMessage baseMessage,final String scanParam,final int fromEvent){
//        new Thread(()->{
//            try {
//                String openId = baseMessage.getFromUserName();
//                WechatUser wechatUser = userService.getWechatUser(openId);
//                if(fromEvent == 1){//扫描事件
//                    giveCouponsToUser(scanParam,wechatUser);
//                    logger.info("["+openId+"]扫描事件领取卡券");
//                }else if (fromEvent == 0){//关注事件
//                    giveCouponsToUser(scanParam,wechatUser);
//                    logger.info("["+openId+"]关注事件领取卡券");
//                }
//            }catch (HttpApiException e) {
//                logger.error(e);
//            }
//        }).start();
//    }


    /*
    * 获取用户城市
    * */
    public String getWechatUserCity(WechatUser wechatUser){
        String province = wechatUser.getProvince();
        String city = wechatUser.getCity();
        city = city.replace(" ","").replace("@", "o").replace(" ","").replace("　","")
                .replace("%","％").replace("\\/","|").replace("\\.","。")
                .replace("&","B").replace(":","：").replace("#","井")
                .replace("$","¥").replace("*","米");
        return city;
    }
    public User initUser(WechatUser wechatUser){
        User userReq = new User();
        userReq.setCity(getWechatUserCity(wechatUser));
        userReq.setHeadImg(wechatUser.getHeadimgurl());
        userReq.setUsername(wechatUser.getOpenid());
        userReq.setAccType(0);
        userReq.setSex(wechatUser.getSex()+"");
        String nickName = wechatUser.getNickname();
        nickName = nickName.replace("@","o").replace(" ","").replace("　","")
                .replace("%","％").replace("\\/","|").replace("\\.","。")
                .replace("&","B").replace(":","：").replace("#","井")
                .replace("$","¥").replace("*","米");
        userReq.setNickName(nickName);
        userReq.setUnionid(wechatUser.getUnionid());
        return userReq;
    }

    /*
    * 异步给用户发消息
    * */
    public void asyncPushMsg(final MsgPushReq msgPushReq){
        new Thread(() -> {
            try {
                CustomMsgSender.sendTextMsg(msgPushReq.getOpenid(),msgPushReq.getMsg());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
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
        return "";
    }

    /*
    * 根据关注回复消息
    * */
    public String buildTextMessageForSubscribe(){
        String respContent = subscribeRespContent;
        return respContent;
    }
    /*
    * 新用户送天棒消息——异步发送消息
    * */
    public void asyncBuildTextMessageForSubscribeWhichUserIsNew(final String openId){

    }





    @RequestMapping(value = "/time/now",produces = "application/json;charset=utf-8")
    public Result noewTime(HttpServletRequest request){
        return new Result(0,"success", TimeConvert.convertTimeStamp("YYYY-MM-dd hh:mm:ss"));
    }
}
