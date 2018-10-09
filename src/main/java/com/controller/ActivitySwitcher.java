package com.controller;

import com.entites.Result;
import com.exception.DealException;
import com.exception.MyException;
import com.util.ActivityUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huyoucheng on 2017/5/31.
 */
@RestController
@RequestMapping(value = "/activity")
public class ActivitySwitcher {

    private static final String isHaveKeyWordActivity = "isHaveKeyWordActivity";
    private static final String isHaveSubscribeActivity = "isHaveSubscribeActivity";
    private static final String isHaveScanActivity = "isHaveScanActivity";
    private static final String isHaveNewUserGiveTianbangActivity = "isHaveNewUserGiveTianbangActivity";
    private static final String isHaveNewUserGiveCoupons = "isHaveNewUserGiveCoupons";

    private Logger logger = Logger.getLogger(ActivitySwitcher.class);
    private String controllerName = "ActivitySwitcher";

    @RequestMapping(value = "/{activityname}/{on_off}",produces = "application/json;charset=utf-8")
    public Result turn_On_Off_activity(@PathVariable("activityname") String activityname,
                                       @PathVariable("on_off") String on_off){
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Result result = new Result();
        logger.info("activityname:"+activityname+"--on_off:"+on_off);
        try {
            if(!on_off.trim().equalsIgnoreCase("on")  && !on_off.trim().equalsIgnoreCase("off")){
                throw new MyException("on_off string doesn't adapt",511,"on_off string doesn't adapt");
            }else {
                boolean isOn = on_off.trim().equalsIgnoreCase("on");
                if(activityname.trim().equalsIgnoreCase(isHaveKeyWordActivity)){
                    ActivityUtil.setIsHaveKeyWordActivity(isOn);
                }else if(activityname.trim().equalsIgnoreCase(isHaveSubscribeActivity)){
                    ActivityUtil.setIsHaveSubscribeActivity(isOn);
                }else if(activityname.trim().equalsIgnoreCase(isHaveScanActivity)){
                    ActivityUtil.setIsHaveKeyWordActivity(isOn);
                }else if(activityname.trim().equalsIgnoreCase(isHaveNewUserGiveTianbangActivity)){
                    ActivityUtil.setIsHaveNewUserGiveTianbangActivity(isOn);
                }else if(activityname.trim().equalsIgnoreCase(isHaveNewUserGiveCoupons)){
                    ActivityUtil.setIsHaveNewUserGiveCoupons(isOn);
                }else {
                    throw new MyException("activity not exist",512,"activity not exist");
                }
                Map map = new HashMap();
                map.put("isHaveKeyWordActivity",ActivityUtil.isHaveKeyWordActivity());
                map.put("isHaveSubscribeActivity",ActivityUtil.isHaveSubscribeActivity());
                map.put("isHaveScanActivity",ActivityUtil.isHaveScanActivity());
                map.put("isHaveNewUserGiveTianbangActivity",ActivityUtil.isHaveNewUserGiveTianbangActivity());
                map.put("isHaveNewUserGiveCoupons",ActivityUtil.isHaveNewUserGiveCoupons());
                result = new Result(0,"success",map);
                logger.info("activities:("+map+")");
            }
        }catch (MyException e){
            result = DealException.dealMyException(e,logger,controllerName,methodName);
        }
        return result;
    }

}
