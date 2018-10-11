package com.custommessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by huyoucheng on 2018/10/9.
 */
public class NewsMsg extends BaseMsg {

    private ObjectNode news;

    public NewsMsg(){}

    public NewsMsg(ObjectNode news) {
        this.news = news;
        super.setMsgtype("news");
    }

    public NewsMsg(String touser, ObjectNode news) {
        super(touser, "news");
        this.news = news;
    }

    public NewsMsg(String touser, String title,String description,String url,String picurl) {
        super(touser, "news");
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode nodes = mapper.createArrayNode();
        ObjectNode node = mapper.createObjectNode();
        node.put("title",title);
        node.put("description",description);
        node.put("url",url);
        node.put("picurl",picurl);
        nodes.add(node);

        ObjectNode node_articles = mapper.createObjectNode();
        node_articles.put("articles",nodes);
        this.news = node_articles;
    }

    public ObjectNode getNews() {
        return news;
    }

    public void setNews(ObjectNode news) {
        this.news = news;
    }
}
