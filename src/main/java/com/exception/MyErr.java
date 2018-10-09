package com.exception;

/**
 * Created by thinkpad on 2016/7/22.
 */
public enum MyErr {

    HTTPTIMEOUT("HTTP请求超时",5999,"http_time_out"),
    SESSIONNULL("没有会话或者会话过期",6999,"no-session"),
    SIGNERR("签名错误",7000),
    REDIRECTTIMEOUTERR("重定向超时",7001,"redirect-time-out"),
    REDISSIDERR("redis里面没有相对应的sid",7002,"redis-sid-null"),
    USERAPIERR("无法从API获取user",7003,"user-api-null"),
    USERSESSIONERR("session里面没有user",7004,"user-session-null"),
    RESTAURANTSESSIONERR("session里面没有所选择的餐厅",7005,"restaurant-session-null"),
    FOODSSESSIONERR("session里面没有所选的foods",7006,"foods-session-null"),
    TIANBANGSESSIONERR("session里面没有orderRsp",7007,"orderRsp-session-null"),
    ORDERSSESSIONERR("session里面没有orderRsp",7008,"orderRsp-session-null"),
    OAUTHUSERSESSIONERR("session里面没有Oath2-user",7009,"Oath2-user-session-null"),
    WEIXINPAYERR("速位微信支付网关返回异常",7010,"weixinpay-res-err"),
    ALIPAYERR("速位支付宝支付网关返回异常",7011,"alipay-res-err"),
    NOPAYTYPEERR("无效支付类型",7012,"no-payType-err"),
    NOTENOUGHTIANBANG("天棒不足以兑换商品",7013,"not-enough-tianbang"),
    JEDISERR("jedis为空",7014,"jedis-null"),
    PHONECODEERR("号码或者验证码错误",7015,"phone-or-code-err"),
    CREATEUSERFAIL("创建新用户失败，返回null",7016,"create-user-fail"),
    RESTAURANTCLOSED("餐厅已经关闭",7017,"restaurant-closed");

    private String throwMsg;
    private int errCode;
    private String errMsg;

    MyErr(String errMsg, int errCode, String throwMsg) {
        this.throwMsg = throwMsg;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    MyErr(String throwMsg, int errCode) {
        this.throwMsg = throwMsg;
        this.errCode = errCode;
    }

    public String getThrowMsg() {
        return throwMsg;
    }

    public void setThrowMsg(String throwMsg) {
        this.throwMsg = throwMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
