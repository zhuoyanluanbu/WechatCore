package com.entites;

/**
 * Created by huyoucheng on 2017/4/7.
 */
public class QrTempReq extends MyObject{

    private int expire_seconds = 2592000;//一个月
    private String action_name = "QR_SCENE";
    private QrActionInfo action_info;

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public QrActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(QrActionInfo action_info) {
        this.action_info = action_info;
    }

    public QrTempReq() {
    }

    public QrTempReq(QrActionInfo action_info) {
        this.action_info = action_info;
    }
}
