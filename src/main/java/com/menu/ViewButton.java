package com.menu;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class ViewButton extends Button {

    private String url;

    public ViewButton() {
    }

    public ViewButton(String url) {
        this.url = url;
    }

    public ViewButton(String name, String url) {
        super("view", name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
