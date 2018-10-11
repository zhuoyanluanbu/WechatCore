package com.custommessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by huyoucheng on 2018/10/9.
 */
public class TextMsg extends BaseMsg {

    private ObjectNode text;

    public TextMsg() {
    }

    public TextMsg(String textContent) {
        ObjectNode node = new ObjectMapper().createObjectNode();
        node.put("content",textContent);
        this.text = node;
    }

    public TextMsg(String touser, String textContent) {
        super(touser, "text");
        ObjectNode node = new ObjectMapper().createObjectNode();
        node.put("content",textContent);
        this.text = node;
    }

    public ObjectNode getText() {
        return text;
    }

    public void setText(ObjectNode text) {
        this.text = text;
    }
}
