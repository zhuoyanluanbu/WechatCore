package com.entites;

/**
 * Created by huyoucheng on 2017/11/21.
 */
public class OpenId extends MyObject {
    private String officialAccount = "";
    private String miniApp = "";
    private String app = "";

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getOfficialAccount() {
        return officialAccount;
    }

    public void setOfficialAccount(String officialAccount) {
        this.officialAccount = officialAccount;
    }

    public String getMiniApp() {
        return miniApp;
    }

    public void setMiniApp(String miniApp) {
        this.miniApp = miniApp;
    }

    public OpenId() {
    }

    public OpenId(String officialAccount, String miniApp) {
        this.officialAccount = officialAccount;
        this.miniApp = miniApp;
    }

    public OpenId(String officialAccount) {
        this.officialAccount = officialAccount;
    }

    public OpenId(String officialAccount, String miniApp, String app) {
        this.officialAccount = officialAccount;
        this.miniApp = miniApp;
        this.app = app;
    }
}
