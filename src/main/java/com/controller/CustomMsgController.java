package com.controller;

import com.entites.Result;
import com.util.GetTokenTicket;
import com.util.WechatRequests;
import custom.message.CustomMsgSender;
import custom.message.Msg;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by huyoucheng on 2018/10/9.
 */
@RestController
@RequestMapping(value = "/msg",produces = "application/json;charset=utf-8")
public class CustomMsgController {

    static Logger logger = Logger.getLogger(CustomMsgController.class);

    @RequestMapping(value = "/wechat_accesstoken_ticket",method = RequestMethod.GET)
    public Result getWechatTokenAndTicket(){
        Result result = new Result();
        try {
            result = new Result(0,"success", GetTokenTicket.wechatTokenAndTicket);
        }catch (Exception e){
            logger.error(e);
        }
        return result;
    }


    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public Result sendCustomMsg(@RequestBody Msg msg){
        Result result = new Result();
        try {
            String toUser = msg.getTouser();
            String msgType = msg.getMsgtype();
            Object content = msg.getContent();
            if (msgType.equalsIgnoreCase("text")){//纯文本消息
                WechatRequests.WechatErr res = CustomMsgSender.sendTextMsg(toUser, (String) content);
                result = new Result(res.errcode,res.errmsg,"");
            }else if (msgType.equalsIgnoreCase("news")){//图文消息
                Map<String,String> map = (HashMap<String,String>)content;
                String title = map.get("title");
                String description = map.get("description");
                String url = map.get("url");
                String picurl = map.get("picurl");
                WechatRequests.WechatErr res = CustomMsgSender.sendNewsMsg(toUser,title,description,url,picurl);
                result = new Result(res.errcode,res.errmsg,"");
            }else if (msgType.equalsIgnoreCase("minipropramPage")){//小程序页面消息
                Map<String,String> map = (HashMap<String,String>)content;
                String title = map.get("title");
                String appid = map.get("appid");
                String pagepath = map.get("pagepath");
                String thumb_media_id = map.get("thumb_media_id");
                WechatRequests.WechatErr res = CustomMsgSender.sendMinipropramMsg(toUser,title,appid,pagepath,thumb_media_id);
                result = new Result(res.errcode,res.errmsg,"");
            }
        }catch (Exception e){
            logger.error(e);
        }
        return result;
    }

}
