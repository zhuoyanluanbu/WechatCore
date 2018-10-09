package com.message.response;

import com.message.MessageUtil;
import com.message.entity.BaseMessage;
import com.message.entity.TextMessage;
import com.util.TimeConvert;

import java.util.Date;

/*
 * 回复文字
 * author:hyc
 * 
 * */

public class TextMessageResponse{


	public static String buildMessageResponse(BaseMessage baseMessage,String toUserRespContent){
		String textMessageResponseXml = "<xml>" +
				"<ToUserName><![CDATA[" + baseMessage.getFromUserName() + "]]></ToUserName>" +
				"<FromUserName><![CDATA[" + baseMessage.getToUserName() + "]]></FromUserName>" +
				"<CreateTime><![CDATA[" + TimeConvert.convertTimeStamp("MMddHHmmssSSS") + "]]></CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[" + toUserRespContent + "]]></Content>" +
				"</xml>";
		return textMessageResponseXml;
	}

	public static String buildMessageResponse(String fromUserName,String toUserName,String toUserRespContent){
		String textMessageResponseXml = "<xml>" +
				"<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>" +
				"<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>" +
				"<CreateTime><![CDATA[" + TimeConvert.convertTimeStamp("MMddHHmmssSSS") + "]]></CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[" + toUserRespContent + "]]></Content>" +
				"</xml>";
		return textMessageResponseXml;
	}

}
