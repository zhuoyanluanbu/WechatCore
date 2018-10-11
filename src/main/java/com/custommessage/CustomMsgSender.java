package com.custommessage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.GetTokenTicket;
import com.util.WechatRequests;

/**
 * Created by huyoucheng on 2018/10/9.
 */
public class CustomMsgSender {

    static ObjectMapper mapper = new ObjectMapper();

    public static WechatRequests.WechatErr sendTextMsg(String touser,String textContent) throws Exception{
        return dealJson(WechatRequests.sendCustomMsg(GetTokenTicket.wechatTokenAndTicket.getToken(),
                new TextMsg(touser, textContent)));
    }

    public static WechatRequests.WechatErr sendNewsMsg(String touser, String title,String description,String url,String picurl) throws Exception{
        return dealJson(WechatRequests.sendCustomMsg(GetTokenTicket.wechatTokenAndTicket.getToken(),
                new NewsMsg(touser, title, description, url, picurl)));
    }

    public static WechatRequests.WechatErr sendMinipropramMsg(String touser, String title,String appid,String pagepath,String thumb_media_id) throws Exception{
        return dealJson(WechatRequests.sendCustomMsg(GetTokenTicket.wechatTokenAndTicket.getToken(),
                new MiniprogramPageMsg(touser, title, appid, pagepath, thumb_media_id)));
    }

    private static WechatRequests.WechatErr dealJson(String wechatRes) throws Exception{
        JsonNode jsonNode = mapper.readTree(wechatRes);
        int errcode = jsonNode.path("errcode").asInt();
        String errmsg = jsonNode.path("errmsg").asText();
        return new WechatRequests().new WechatErr(errcode,errmsg);
    }



}
