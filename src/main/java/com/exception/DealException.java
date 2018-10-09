package com.exception;

import com.entites.Result;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created by huyoucheng on 2017/3/3.
 */
public class DealException extends MyException implements Serializable {



    public static Result dealHttpApiException(HttpApiException e,Logger logger,String controllerName,String methodName){
        int statuscode = e.getStatusCode();
        String errMsg = e.getErrMsg();
        String resp = e.getResp();
        e.printStackTrace();
        logger.error(controllerName+"==>"+methodName+"---HttpApiException--状态码:[" + statuscode + "]|返回信息[" + resp + "]|错误信息[" + errMsg + "]");
        int respErrCode = e.getRespErrCode();
        String respErrMsg = e.getRespErrMsg();
        RespErr respErr = new RespErr(respErrCode,respErrMsg);
        Result result = new Result(statuscode,respErrMsg,respErr);
        return result;
    }
    public static Result dealMyException(MyException e,Logger logger,String controllerName,String methodName){
        e.printStackTrace();
        int errCode = e.getErrCode();
        String errMsg = e.getErrMsg();
        logger.error(controllerName+"==>"+methodName+"---MyException[" + errCode + "]:" + e, e);
        Result result = new Result(errCode,errMsg,errMsg);
        return result;
    }

}
