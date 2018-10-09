package com.message.entity;

/**
 * Created by huyoucheng on 2017/5/26.
 */
public class SampleMessage extends BaseMessage {
    private String MsgId;

    public String getMsgId() {
        return this.MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

    public SampleMessage(){}

    public SampleMessage(String msgId) {
        MsgId = msgId;
    }

    public SampleMessage(String toUserName, String fromUserName, String createTime, String msgType, String msgId) {
        super(toUserName, fromUserName, createTime, msgType);
        MsgId = msgId;
    }
}
