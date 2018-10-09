package com.util;

/**
 * Created by huyoucheng on 2017/5/26.
 */
public class ActivityUtil {

    private static volatile boolean isHaveKeyWordActivity = false;//是否有关键字活动

    private static volatile boolean isHaveSubscribeActivity = true;//是否有新用户关注活动

    private static volatile boolean isHaveScanActivity = true;//是否有用户扫描二维码活动



    private static volatile boolean isHaveNewUserGiveTianbangActivity = true;//新用户送天棒

    private static volatile boolean isHaveNewUserGiveCoupons = false;//新用户送卡券


    public static boolean isHaveKeyWordActivity() {
        return isHaveKeyWordActivity;
    }

    public static synchronized void setIsHaveKeyWordActivity(boolean isHaveKeyWordActivity) {
        ActivityUtil.isHaveKeyWordActivity = isHaveKeyWordActivity;
    }

    public static boolean isHaveSubscribeActivity() {
        return isHaveSubscribeActivity;
    }

    public static synchronized void setIsHaveSubscribeActivity(boolean isHaveSubscribeActivity) {
        ActivityUtil.isHaveSubscribeActivity = isHaveSubscribeActivity;
    }

    public static boolean isHaveScanActivity() {
        return isHaveScanActivity;
    }

    public static  synchronized void setIsHaveScanActivity(boolean isHaveScanActivity) {
        ActivityUtil.isHaveScanActivity = isHaveScanActivity;
    }

    public static boolean isHaveNewUserGiveTianbangActivity() {
        return isHaveNewUserGiveTianbangActivity;
    }

    public static synchronized void setIsHaveNewUserGiveTianbangActivity(boolean isHaveNewUserGiveTianbangActivity) {
        ActivityUtil.isHaveNewUserGiveTianbangActivity = isHaveNewUserGiveTianbangActivity;
    }

    public static boolean isHaveNewUserGiveCoupons() {
        return isHaveNewUserGiveCoupons;
    }

    public static synchronized void setIsHaveNewUserGiveCoupons(boolean isHaveNewUserGiveCoupons) {
        ActivityUtil.isHaveNewUserGiveCoupons = isHaveNewUserGiveCoupons;
    }
}
