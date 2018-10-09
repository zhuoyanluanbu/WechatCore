package com.entites;

/**
 * Created by huyoucheng on 2017/6/2.
 */
public class MsgPushReq extends MyObject {
    private String msg;
    private String openid;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public MsgPushReq() {
    }

    public MsgPushReq(String msg, String openid) {
        this.msg = msg;
        this.openid = openid;
    }
}
