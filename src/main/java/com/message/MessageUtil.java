package com.message;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {

	//解析微信服务器发送过来的请求
	public static Map<String,String> parseXml(HttpServletRequest request){
		Map<String,String> map=new HashMap<String, String>();
		 
		//如果加密方式为微信安全加密
		if("aes".equalsIgnoreCase(request.getParameter("encrypt_type"))){
			String msgSignature=request.getParameter("msg_signature");//加密的签名
			String timeStamp=request.getParameter("timestamp");
			String nonce=request.getParameter("nonce");
			String encryptType=request.getParameter("encrypt_type");
			map.put("msgSignature", msgSignature);
			map.put("timeStamp", timeStamp);
			map.put("nonce", nonce);
			map.put("encryptType", encryptType);
		}
		
		try {
			//得到微信服务器传过来的流
			InputStream inputstream=request.getInputStream();
			//读取流里面的xml内容
			SAXReader reader=new SAXReader();
			Document document=reader.read(inputstream);
			//得到xml里面的根节点
			Element root=document.getRootElement();
			//得到根节点下的所有子节点
			List<Element> elementlist=root.elements();
			//遍历子节点,把每一个节点里面的内容放进map键值对
			for(Element e:elementlist){
				String key = e.getName();
				String value = e.getText();
				key = key.substring(0,1).toLowerCase() + key.substring(1,key.length());
				map.put(key, value);
			}
			inputstream.close();
			inputstream=null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}

	
}
