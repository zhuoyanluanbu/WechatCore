package com.controller;

import com.entites.*;
import com.exception.HttpApiException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.GetTokenTicket;
import com.util.HttpHelper;
import com.util.WechatRequests;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Created by huyoucheng on 2017/4/7.
 */
@RestController
@RequestMapping(value = "/qrcode")
public class QrCodeController {

    Logger logger = Logger.getLogger(QrCodeController.class);

    ObjectMapper mapper = new ObjectMapper();


    // http://192.168.0.128:8082/qrcode/tickect/sourceid=122&eventname=scan

    /*
    * 永久二维码
    * */
    @RequestMapping(value = "/tickect/forever/{params}",produces = "application/json;charset=utf-8")
    public QrResp getQrTicket(@PathVariable("params")String params){
        QrResp qrResp = new QrResp();
        try {
            String scene_str = params;//微信要求length 1--64
            QrForeverReq qrForeverReq = new QrForeverReq(new QrActionInfo(new QrForeverScene(scene_str)));
            qrResp = WechatRequests.getQrTicketForEver(qrForeverReq,GetTokenTicket.wechatTokenAndTicket.getToken());
        } catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return qrResp;
    }


    /*
    * 临时二维码
    * */
    @RequestMapping(value = "/tickect/temp/{scene_id}",produces = "application/json;charset=utf-8")
    public QrResp getQrTicket(@PathVariable("scene_id")int scene_id){
        QrResp qrResp = new QrResp();
        try {
            QrTempReq qrTempReq = new QrTempReq(new QrActionInfo(new QrTempScene(scene_id)));
            qrResp = WechatRequests.getQrTicketTemp(qrTempReq,GetTokenTicket.wechatTokenAndTicket.getToken());
        }  catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return qrResp;
    }


}
