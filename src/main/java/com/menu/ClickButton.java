package com.menu;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class ClickButton extends Button {

    private String key;

    public ClickButton(String key) {
        this.key = key;
    }

    public ClickButton(String name, String key) {
        super("click", name);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
