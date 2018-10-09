package com.service;

import com.entites.CardGiveOutRsp;
import com.entites.MyObject;
import com.entites.User;
import com.exception.HttpApiException;
import com.util.HttpHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by huyoucheng on 2017/6/5.
 */
@Service
public class CouponService {

    Logger logger = Logger.getLogger(MsgService.class);

    @Value("${accessServer}")
    String accessServer;

    @Value("${giveOutCouponsUrl}")
    String giveOutCouponsUrl;

    public CardGiveOutRsp giveOutCoupons(User user,String eventName,String sourcename) throws HttpApiException{
        String api = giveOutCouponsUrl.replace("cardGiveOut", "cardGiveOutByName");
        String res = HttpHelper.httpGet(api+
                "?sourceName="+sourcename+"&userId="+user.getUserId()+"&eventName="+eventName,null);
        logger.info("CouponService==>giveOutCoupons-->user:("+user.toJson()+")-->res:("+res+")");
        CardGiveOutRsp cardGiveOutRsp = MyObject.toBean(res,CardGiveOutRsp.class);
        return cardGiveOutRsp;
    }

}
