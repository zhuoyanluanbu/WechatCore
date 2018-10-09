package com.message.response;

import com.message.MessageUtil;
import com.message.entity.Article;
import com.message.entity.NewsMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 回复图文
 * 
 * */
public class newsMessageResponse {

	public NewsMessage getNewMessageResponse(String fromUserName,String toUserName,int count,
			String title,String picUrl,String description,String url){
		
		
		NewsMessage newsMessage=new NewsMessage();
			
			List<Article> articles=new ArrayList<Article>();
			articles.add(getArticel(title, picUrl, description, url));
		
			newsMessage.setCreateTime(new Date().getTime()+"");
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
//			newsMessage.setMsgType(MessageUtil.);
			newsMessage.setArticleCount(count);
			newsMessage.setArticles(articles);
			
		return newsMessage;
		
	}
	
	private Article getArticel(String title,String picUrl,String description,String url){
		Article article=new Article();
			article.setTitle(title);
			article.setPicUrl(picUrl);
			article.setDescription(description);
			article.setUrl(url);
		return article;
	}
}
