package com.menu;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class MiniprogramButton extends ViewButton {

    private String appid;

    private String pagepath;

    public MiniprogramButton(String appid, String pagepath) {
        this.appid = appid;
        this.pagepath = pagepath;
        super.setType("miniprogram");
    }

    public MiniprogramButton(String url, String appid, String pagepath) {
        super(url);
        this.appid = appid;
        this.pagepath = pagepath;
        super.setType("miniprogram");
    }

    public MiniprogramButton(String name, String url, String appid, String pagepath) {
        super(name, url);
        this.appid = appid;
        this.pagepath = pagepath;
        super.setType("miniprogram");
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}
