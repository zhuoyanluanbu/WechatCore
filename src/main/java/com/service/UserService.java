package com.service;

import com.entites.MyObject;
import com.entites.User;
import com.entites.UserRepair;
import com.entites.WechatUser;
import com.exception.HttpApiException;
import com.exception.MyException;
import com.util.HttpHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by huyoucheng on 2017/6/2.
 */
@Service
public class UserService {

    Logger logger = Logger.getLogger(MsgService.class);

    @Value("${accessServer}")
    String accessServer;

    @Value("${wechatUserService}")
    String wechatUserService;
    /*
    * 获取微信的用户信息
    * */
    public WechatUser getWechatUser(String openId) throws HttpApiException{
        WechatUser wechatUser = null;
        String res = HttpHelper.httpGet(wechatUserService + "/wechatuser/" + openId, null);
        logger.info("UserService==>getWechatUser-->res:("+res+")");
        wechatUser = MyObject.toBean(res,WechatUser.class);
        return wechatUser;
    }

    /*
    * 是否是新用户
    * */
    public boolean isNewUser(String unionid,String openId,String city){
        String res = "";
        try {
            res = HttpHelper.httpGet(accessServer + "/user/v2/"+ unionid +"/" + openId + "/0.0/0.0/" + city, null);
        } catch (HttpApiException e) {
            logger.error(e);
        }
        if (res.isEmpty()) return true;
        return false;
    }


    /*
    * 获取用户信息
    * */
    public User getUserInfo(User userReq) throws HttpApiException{
        String res = HttpHelper.httpPost(accessServer + "/user/info", userReq.toJsonNode(), false);
        logger.info("UserService==>getUserInfo-->res:("+res+")");
        User userResp = MyObject.toBean(res,User.class);
        return userResp;
    }

    /*
    * 补全openid等信息
    * */
    public boolean repairUser(UserRepair userRepair) throws MyException,HttpApiException{
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String api = accessServer + "/user/repair";
        logger.info("/user/repair ==> "+ methodName +" --> body:("+userRepair.toJson()+")");
        String res = HttpHelper.httpPost(api, userRepair.toJsonNode(), false);
        logger.info("/user/repair ==> "+ methodName +" --> body:("+userRepair.toJson()+") -> res:("+res+")");
        if (res.equalsIgnoreCase("true")) return true;
        return false;
    }
}
