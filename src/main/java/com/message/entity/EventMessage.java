package com.message.entity;

/**
 * Created by huyoucheng on 2017/5/26.
 */
public class EventMessage extends BaseMessage {
    private String Event;

    public String getEvent() {
        return this.Event;
    }

    public void setEvent(String event) {
        this.Event = event;
    }

    public EventMessage(){}

    public EventMessage(String event) {
        this.Event = event;
    }

    public EventMessage(String toUserName, String fromUserName, String createTime, String msgType, String event) {
        super(toUserName, fromUserName, createTime, msgType);
        this.Event = event;
    }
}
