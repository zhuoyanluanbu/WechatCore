package com.service;

import com.entites.MsgPushReq;
import com.exception.HttpApiException;
import com.util.HttpHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by huyoucheng on 2017/6/2.
 */
@Service
public class MsgService {


    Logger logger = Logger.getLogger(MsgService.class);

    @Value("${accessServer}")
    String accessServer;

    /*
    *  发送消息
    * */
    public boolean pushTextMsg(MsgPushReq msgPushReq){
        boolean isSuc = false;
        try {
            String res = HttpHelper.httpPost(accessServer + "/message/pushmsg", msgPushReq.toJsonNode(), false);
            logger.info("(返回)"+accessServer+"/message/pushmsg-->msgPushReq("+msgPushReq.toJson()+")--res:("+res+")");
            if (res.trim().equalsIgnoreCase("true")) isSuc = true;
        } catch (HttpApiException e){
            logger.error(e);
        }
        return isSuc;
    }

}
