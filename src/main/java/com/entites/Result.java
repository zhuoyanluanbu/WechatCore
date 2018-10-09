package com.entites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Created by thinkpad on 2016/7/11.
 */
public class Result extends MyObject {
    private int errCode=1;
    private String errMsg="err";
    @JsonIgnore
    private Object res;

    public Result() {
    }

    public Result(int errCode, String errMsg, Object res) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.res = res;
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

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }

    private ObjectMapper mapper = new ObjectMapper();
    public String toJson(){
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
