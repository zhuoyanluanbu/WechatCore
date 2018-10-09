package com.message.entity;

public class TextMessage extends SampleMessage{

	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public TextMessage(){}

	public TextMessage(String content) {
		Content = content;
	}

	public TextMessage(String msgId, String content) {
		super(msgId);
		Content = content;
	}

	public TextMessage(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String content) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		Content = content;
	}

}
