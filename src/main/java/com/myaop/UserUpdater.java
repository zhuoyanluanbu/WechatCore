package com.myaop;

import com.entites.UserData;
import com.service.UserClient;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by huyoucheng on 2018/10/12.
 */
@Configuration
@Aspect
public class UserUpdater {

    static Logger logger = Logger.getLogger(UserUpdater.class);

    @Autowired
    UserClient userClient;

    public UserUpdater(){}

    @Pointcut("execution(* *.dealUserData(..))")
    public void dealUserDataPoint(){}

    @AfterReturning(pointcut = "dealUserDataPoint()",returning = "userDataObj")
    public void updateUserData(Object userDataObj){
        UserData userData = (UserData) userDataObj;
        logger.info("准备更新userData:("+ userData.toJson() +")");
        new Thread(() -> {
            userClient.updateUser(userData);
        }).start();

    }

}
