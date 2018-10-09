package com.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/9/23.
 */
public class HttpApiException extends Exception {

    private int statusCode;
    private String resp;
    private String errMsg;
    private int respErrCode = -1;
    private String respErrMsg = "error";

    private ObjectMapper mapper = new ObjectMapper();

    private void analysisResp(){
        try {
            JsonNode jsonNode = mapper.readTree(this.resp);
            this.respErrCode = jsonNode.path("errCode").asInt(-1);
            this.respErrMsg = jsonNode.path("errMsg").asText("error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public HttpApiException() {
    }


    public HttpApiException(int statusCode, String resp, String errMsg) {
        this.statusCode = statusCode;
        this.resp = resp;
        this.errMsg = errMsg;
        analysisResp();
    }

    public HttpApiException(String message, int statusCode, String resp, String errMsg) {
        super(message);
        this.statusCode = statusCode;
        this.resp = resp;
        this.errMsg = errMsg;
        analysisResp();
    }

    public HttpApiException(String message, Throwable cause, int statusCode, String resp, String errMsg) {
        super(message, cause);
        this.statusCode = statusCode;
        this.resp = resp;
        this.errMsg = errMsg;
        analysisResp();
    }

    public HttpApiException(Throwable cause, int statusCode, String resp, String errMsg) {
        super(cause);
        this.statusCode = statusCode;
        this.resp = resp;
        this.errMsg = errMsg;
        analysisResp();
    }

    public HttpApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int statusCode, String resp, String errMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
        this.resp = resp;
        this.errMsg = errMsg;
        analysisResp();
    }

    public static void main(String[] args) {
        HttpApiException httpApiException = new HttpApiException("http状态码"+500+"--{\"errCoe\":123,\"errMsg\":\"错误\"}",
                500,"hjgj","err");
        System.out.println(httpApiException.getStatusCode()+"--"+httpApiException.getRespErrCode()+"--"+httpApiException.getRespErrMsg());
    }
}
