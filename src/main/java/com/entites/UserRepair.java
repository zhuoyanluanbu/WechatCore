package com.entites;

/**
 * Created by huyoucheng on 2018/2/27.
 */
public class UserRepair extends MyObject{

    private int id = -1;
    private int uid = -1;
    private String unionid;
    private String wx_openid;
    private String wxapp_openid;
    private String app_openid;
    private String parameter_1;
    private String parameter_2;
    private String parameter_3;

    public UserRepair() {
    }

    public UserRepair(String unionid, String wx_openid, String wxapp_openid, String app_openid) {
        this.unionid = unionid;
        this.wx_openid = wx_openid;
        this.wxapp_openid = wxapp_openid;
        this.app_openid = app_openid;
    }

    public UserRepair(int id, int uid, String unionid, String wx_openid, String wxapp_openid, String app_openid, String parameter_1, String parameter_2, String parameter_3) {
        this.id = id;
        this.uid = uid;
        this.unionid = unionid;
        this.wx_openid = wx_openid;
        this.wxapp_openid = wxapp_openid;
        this.app_openid = app_openid;
        this.parameter_1 = parameter_1;
        this.parameter_2 = parameter_2;
        this.parameter_3 = parameter_3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getWx_openid() {
        return wx_openid;
    }

    public void setWx_openid(String wx_openid) {
        this.wx_openid = wx_openid;
    }

    public String getWxapp_openid() {
        return wxapp_openid;
    }

    public void setWxapp_openid(String wxapp_openid) {
        this.wxapp_openid = wxapp_openid;
    }

    public String getApp_openid() {
        return app_openid;
    }

    public void setApp_openid(String app_openid) {
        this.app_openid = app_openid;
    }

    public String getParameter_1() {
        return parameter_1;
    }

    public void setParameter_1(String parameter_1) {
        this.parameter_1 = parameter_1;
    }

    public String getParameter_2() {
        return parameter_2;
    }

    public void setParameter_2(String parameter_2) {
        this.parameter_2 = parameter_2;
    }

    public String getParameter_3() {
        return parameter_3;
    }

    public void setParameter_3(String parameter_3) {
        this.parameter_3 = parameter_3;
    }
}
