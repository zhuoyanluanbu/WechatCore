package com.util;

import com.entites.WechatTokenAndTicket;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import custom.message.BaseMsg;
import org.apache.log4j.Logger;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class WechatRequests {

    static Logger logger = Logger.getLogger(WechatRequests.class);

    static ObjectMapper mapper = new ObjectMapper();

    public final static String appId = "wx362c850dc34b06d3";

    public final static String appSecret = "aa74bfdce698c69bba822076fbe32647";

    // 获取access_token的接口地址（GET） 限200（次/天）
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    // 菜单创建（POST） 限100（次/天）
    public static final String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    // 发送客服消息
    public static final String custom_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";


    //获取accessToken和ticket
    public static WechatTokenAndTicket getAccessTokenAndTicket(){
        WechatTokenAndTicket wechatTokenAndTicket=null;
        try {
            String accessTokenRequestUrl=access_token_url.replace("APPID", appId).replace("APPSECRET", appSecret);
            //获取凭证用GET方法
            String res = HttpHelper.httpsGet(accessTokenRequestUrl);
            logger.info("获取accessToken:("+res+")");
            JsonNode node = mapper.readTree(res);
            String accessToken = node.path("access_token").asText();
            String ticket = getTicket(accessToken);
            if (!ticket.isEmpty()) {
                wechatTokenAndTicket = new WechatTokenAndTicket(accessToken,7200,ticket);
            }
        }catch (Exception e){
            logger.error(e);
        }
        return wechatTokenAndTicket;
    }

    public static String getTicket(String token){
        String ticket="";
        String ticketRequestUrl =  "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi".replace("ACCESS_TOKEN", token);
        try {
            String res = HttpHelper.httpsGet(ticketRequestUrl);
            logger.info("获取ticket:("+res+")");
            JsonNode node = mapper.readTree(res);
            ticket = node.path("ticket").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }

    // 菜单生成
    public static String createMenu(String json,String accessToken){
        String menu_create_RequestUrl = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        String res = HttpHelper.httpsPost(menu_create_RequestUrl, json);
        System.out.println(res);
        return res;
    }

    // 发送客服消息
    public static String sendCustomMsg(String accessToken,BaseMsg baseMsg){
        String custom_message_RequestUrl = custom_message_url.replace("ACCESS_TOKEN",accessToken);
        String res = HttpHelper.httpsPost(custom_message_RequestUrl, baseMsg.toJson());
        System.out.println(res);
        return res;
    }


    public class WechatErr{
        public int errcode;
        public String errmsg;

        public WechatErr() {
        }

        public WechatErr(int errcode, String errmsg) {
            this.errcode = errcode;
            this.errmsg = errmsg;
        }
    }

}
