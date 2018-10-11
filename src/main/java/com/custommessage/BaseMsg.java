package com.custommessage;

import com.entites.MyObject;

/**
 * Created by huyoucheng on 2018/10/9.
 */
public class BaseMsg extends MyObject {

    private String touser;

    private String msgtype;

    public BaseMsg() {
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public BaseMsg(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }
}
