package com.message.entity;

import com.entites.MyObject;

public class BaseMessage extends MyObject{

	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;


	public String getToUserName() {
		return this.ToUserName;
	}

	public void setToUserName(String toUserName) {
		this.ToUserName = toUserName;
	}

	public String getFromUserName() {
		return this.FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.FromUserName = fromUserName;
	}

	public String getCreateTime() {
		return this.CreateTime;
	}

	public void setCreateTime(String createTime) {
		this.CreateTime = createTime;
	}

	public String getMsgType() {
		return this.MsgType;
	}

	public void setMsgType(String msgType) {
		this.MsgType = msgType;
	}

	public BaseMessage() {
	}

	public BaseMessage(String toUserName, String fromUserName, String createTime, String msgType) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
	}
	
}
