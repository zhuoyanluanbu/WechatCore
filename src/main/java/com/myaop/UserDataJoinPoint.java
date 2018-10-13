package com.myaop;

import com.entites.DetailAddress;
import com.entites.SystemGiveForm;
import com.entites.UserData;
import com.entites.WechatUser;
import com.service.AccountClient;
import com.service.UserClient;
import com.util.GetTokenTicket;
import com.util.WechatRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by huyoucheng on 2018/10/13.
 */
@Component
public class UserDataJoinPoint {

    @Autowired
    UserClient userClient;

    @Autowired
    AccountClient accountClient;

    //用户新增或者更新信息
    public UserData dealUserData(String fromUserName,DetailAddress detailAddress){
        //新用户只要关注就赠送余额
        long invitUserId = -1;//邀请人的id
        if (fromUserName.contains("~~~")){
            invitUserId = Long.parseLong(fromUserName.split("~~~")[1]);
            fromUserName = fromUserName.split("~~~")[0];
        }
        UserData userData = initUser(WechatRequests.getWechatUserByOpenId(GetTokenTicket.wechatTokenAndTicket.getToken(), fromUserName));
        UserData userDataInBD = getUserData(fromUserName);
        if (userDataInBD == null){//新用户，进行注册并送余额
            userData.setInviteUser(invitUserId);
            userData = userClient.saveUser(userData);//新生成的用户
            long uid = userData.getId();
            new Thread(() -> accountClient.systemGive(new SystemGiveForm(uid,5000,1,"新用户关注送50元") ) ).start();
        }else {
            userData = userDataInBD;
        }
        if (detailAddress != null){
            userData.setProvince(detailAddress.getProvince());
            userData.setCity(detailAddress.getCity());
            userData.setLatitude(detailAddress.getLat());
            userData.setLongitude(detailAddress.getLng());
        }
        return userData;
    }

    public UserData initUser(WechatUser wechatUser){
        UserData userData = new UserData();
        userData.setAvatarUrl(wechatUser.getHeadimgurl());
        userData.setGender(wechatUser.getSex());
        userData.setCity(wechatUser.getCity());
        userData.setCountry(wechatUser.getCountry());
        userData.setNickname(wechatUser.getNickname());
        userData.setUserUnionId(wechatUser.getUnionid());
        userData.setOpenId(wechatUser.getOpenid());
        userData.setUserChannel(1);
        userData.setProvince(wechatUser.getProvince());
        return userData;
    }

    //查询后台是否有用户
    public UserData getUserData (String openid){
        return userClient.getUserByOpenId(openid,1);
    }
}
