package com.entites;

/**
 * Created by huyoucheng on 2017/4/7.
 */
public class QrForeverReq extends MyObject {

    private String action_name = "QR_LIMIT_STR_SCENE";
    private QrActionInfo action_info;

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

    public QrForeverReq() {
    }

    public QrForeverReq(String action_name, QrActionInfo action_info) {
        this.action_name = action_name;
        this.action_info = action_info;
    }


    public QrForeverReq(QrActionInfo action_info) {
        this.action_info = action_info;
    }
}
