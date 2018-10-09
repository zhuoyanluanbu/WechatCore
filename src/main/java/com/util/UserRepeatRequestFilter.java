package com.util;

import com.entites.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huyoucheng on 2017/8/10.
 */
@Component
public class UserRepeatRequestFilter {

    static Logger logger = Logger.getLogger(UserRepeatRequestFilter.class);

    public static Map<String,Long> filterMap = new HashMap<String,Long>();

    public boolean filter(User userReq){
        synchronized (this){
            long nowTime = System.currentTimeMillis();
            if(UserRepeatRequestFilter.filterMap.get(userReq.getUsername()) != null ){
                long lastTime = UserRepeatRequestFilter.filterMap.get(userReq.getUsername());
                UserRepeatRequestFilter.filterMap.put(userReq.getUsername(),nowTime);
                if (nowTime - lastTime < 1000){
                    logger.info(userReq.getUsername()+":("+lastTime+","+nowTime+") repeat request");
                    return true;
                }
            }else {
                UserRepeatRequestFilter.filterMap.put(userReq.getUsername(),nowTime);
            }
            return false;
        }
    }

}
