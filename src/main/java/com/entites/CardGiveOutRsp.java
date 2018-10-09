package com.entites;

import java.util.List;

/**
 * Created by huyoucheng on 2017/6/5.
 */
public class CardGiveOutRsp extends MyObject {
    private boolean ok;//是否成功

    private int msgCode;//消息代码，需要时定义

    private String msg;//消息

    private List<CardGiveOutTicketInfo> cgotInfoList;//获取到的卡券列表

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CardGiveOutTicketInfo> getCgotInfoList() {
        return cgotInfoList;
    }

    public void setCgotInfoList(List<CardGiveOutTicketInfo> cgotInfoList) {
        this.cgotInfoList = cgotInfoList;
    }

    public CardGiveOutRsp(){}

    public CardGiveOutRsp(boolean ok, int msgCode, String msg, List<CardGiveOutTicketInfo> cgotInfoList) {
        this.ok = ok;
        this.msgCode = msgCode;
        this.msg = msg;
        this.cgotInfoList = cgotInfoList;
    }

}
