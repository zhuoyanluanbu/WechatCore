package com.menu;

import com.entites.MyObject;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class Button extends MyObject {

    private String type;

    private String name;

    public Button() {
    }

    public Button(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
