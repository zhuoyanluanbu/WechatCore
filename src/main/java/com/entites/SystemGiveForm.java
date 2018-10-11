package com.entites;

/**
 * Created by dave_suwei on 2018/10/3.
 */
public class SystemGiveForm {
    private long userId;
    private int tradeAmount;//系统赠送金额
    private int giveEvent;//赠送事件,1关注微信公众号
    private String tradeDesc;//交易描述

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(int tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public int getGiveEvent() {
        return giveEvent;
    }

    public void setGiveEvent(int giveEvent) {
        this.giveEvent = giveEvent;
    }

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc(String tradeDesc) {
        this.tradeDesc = tradeDesc;
    }

    public SystemGiveForm() {
    }

    public SystemGiveForm(long userId, int tradeAmount, int giveEvent, String tradeDesc) {
        this.userId = userId;
        this.tradeAmount = tradeAmount;
        this.giveEvent = giveEvent;
        this.tradeDesc = tradeDesc;
    }

    @Override
    public String toString() {
        return "SystemGiveForm{" +
                "userId=" + userId +
                ", tradeAmount=" + tradeAmount +
                ", giveEvent=" + giveEvent +
                ", tradeDesc='" + tradeDesc + '\'' +
                '}';
    }
}
