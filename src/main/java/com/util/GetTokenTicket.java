package com.util;

import com.entites.MyObject;
import com.entites.WechatTokenAndTicket;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by huyoucheng on 2017/5/31.
 */
public class GetTokenTicket extends MyObject{

    public static WechatTokenAndTicket wechatTokenAndTicket;


    private static Timer timer;

    static {
        init();
        startTimer();
    }

    private static void init(){
        wechatTokenAndTicket = WechatRequests.getAccessTokenAndTicket();
    }

    private static void startTimer(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                init();
            }
        },1000*60*3,1000*60*3);
    }

}
