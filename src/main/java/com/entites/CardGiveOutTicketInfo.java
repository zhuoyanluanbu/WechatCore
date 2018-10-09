package com.entites;

import java.util.Date;

/**
 * Created by huyoucheng on 2017/6/5.
 */
public class CardGiveOutTicketInfo extends MyObject{

    private int id=-1;//自增长编号
    private int cardType=-1;//卡券的优惠类型，1 为每单抵扣金额 2为每单折扣 ，具体优惠的金额或是折扣大小为DISCOUNT字段决定。
    private String cardName;//名称
    private int discount=-1;//抵扣金额(/分)或者折扣（10%＝10）
    private String des;//描述
    private Date startTime;//卡券有效期开始时间
    private Date endTime;//卡券有效期结束时间
    private int scope=-1;//作用域ID
    private int state=-1;//0为启用。1为失效
    private int days=-1;//从发卡日期起多少天有效，0表示总是有效
    private int useMethod=-1;//使用方式ID
    private int useConditionId=-1;//使用条件ID
    private String useConditionName;//使用条件名称
    private int groupId=-1;//所属卡券组
    private int gosMarkId=-1;//策略区分标识，用于在发卡时区分卡，有的策略会用到
    private int kindId=-1;//卡券分类ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getUseMethod() {
        return useMethod;
    }

    public void setUseMethod(int useMethod) {
        this.useMethod = useMethod;
    }

    public int getUseConditionId() {
        return useConditionId;
    }

    public void setUseConditionId(int useConditionId) {
        this.useConditionId = useConditionId;
    }

    public String getUseConditionName() {
        return useConditionName;
    }

    public void setUseConditionName(String useConditionName) {
        this.useConditionName = useConditionName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGosMarkId() {
        return gosMarkId;
    }

    public void setGosMarkId(int gosMarkId) {
        this.gosMarkId = gosMarkId;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }



    public CardGiveOutTicketInfo() {
    }

    public CardGiveOutTicketInfo(int id, int cardType, String cardName, int discount, String des, Date startTime, Date endTime, int scope, int state, int days, int useMethod, int useConditionId, String useConditionName, int groupId, int gosMarkId, int kindId) {
        this.id = id;
        this.cardType = cardType;
        this.cardName = cardName;
        this.discount = discount;
        this.des = des;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scope = scope;
        this.state = state;
        this.days = days;
        this.useMethod = useMethod;
        this.useConditionId = useConditionId;
        this.useConditionName = useConditionName;
        this.groupId = groupId;
        this.gosMarkId = gosMarkId;
        this.kindId = kindId;
    }

}
