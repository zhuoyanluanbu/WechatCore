package com.exception;


import com.entites.MyObject;

/**
 * Created by huyoucheng on 2017/3/3.
 */
public class RespErr extends MyObject{
    private int respErrCode = -1;
    private String respErrMsg = "error";

    public int getRespErrCode() {
        return respErrCode;
    }

    public void setRespErrCode(int respErrCode) {
        this.respErrCode = respErrCode;
    }

    public String getRespErrMsg() {
        return respErrMsg;
    }

    public void setRespErrMsg(String respErrMsg) {
        this.respErrMsg = respErrMsg;
    }

    public RespErr(int respErrCode, String respErrMsg) {
        this.respErrCode = respErrCode;
        this.respErrMsg = respErrMsg;
    }
}

