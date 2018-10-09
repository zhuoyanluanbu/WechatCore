package com.entites;

/**
 * Created by huyoucheng on 2016/11/4.
 */
public class WechatUser extends MyObject{

    private String openid;
    private String unionid;
    private int sex ;//0未知；1男；2女
    private String nickname = "suwei";
    private String headimgurl = "";
    private int subscribe;
    private String remark = "";
    private int groupid = 0;
    private Object tagid_list;
    private String language;
    private String city;
    private String province;
    private String country;
    private long subscribe_time;
    private String subscribe_scene;
    private int qr_scene;
    private String qr_scene_str;

    public String getSubscribe_scene() {
        return subscribe_scene;
    }

    public void setSubscribe_scene(String subscribe_scene) {
        this.subscribe_scene = subscribe_scene;
    }

    public int getQr_scene() {
        return qr_scene;
    }

    public void setQr_scene(int qr_scene) {
        this.qr_scene = qr_scene;
    }

    public String getQr_scene_str() {
        return qr_scene_str;
    }

    public void setQr_scene_str(String qr_scene_str) {
        this.qr_scene_str = qr_scene_str;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public Object getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(Object tagid_list) {
        this.tagid_list = tagid_list;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public WechatUser(){}

    public WechatUser(String openid, String unionid, int sex, String nickname, String headimgurl, int subscribe, String remark, int groupid, Object tagid_list, String language, String city, String province, String country, long subscribe_time) {
        this.openid = openid;
        this.unionid = unionid;
        this.sex = sex;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.subscribe = subscribe;
        this.remark = remark;
        this.groupid = groupid;
        this.tagid_list = tagid_list;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.subscribe_time = subscribe_time;
    }

    public WechatUser(String openid, String unionid, int sex, String nickname, String headimgurl, int subscribe, String remark, int groupid, Object tagid_list, String language, String city, String province, String country, long subscribe_time, String subscribe_scene, int qr_scene, String qr_scene_str) {
        this.openid = openid;
        this.unionid = unionid;
        this.sex = sex;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.subscribe = subscribe;
        this.remark = remark;
        this.groupid = groupid;
        this.tagid_list = tagid_list;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.subscribe_time = subscribe_time;
        this.subscribe_scene = subscribe_scene;
        this.qr_scene = qr_scene;
        this.qr_scene_str = qr_scene_str;
    }
}
