package com.entites;

/**
 * Created by huyoucheng on 2017/6/2.
 */
public class User extends MyObject {
    private int userId;
    private int accType;
    private String regTime;
    private String noticephone;
    private String channelId;
    private String pushId;
    private String password;
    private String userLevelname;
    private String userLevel;
    private String username;
    private double balance;
    private double mealDiscount;
    private String headImg;
    private String nickName;
    private String sex;
    private String isnew;
    private int burrencyBeans;
    private int burrencyBeansDiscount;
    private String city;
    private String phone;
    private String unionid;

    public User(){}

    public User(int userId, int accType, String regTime, String noticephone, String channelId, String pushId, String password, String userLevelname, String userLevel, String username, double balance, double mealDiscount, String headImg, String nickName, String sex, String isnew, int burrencyBeans, int burrencyBeansDiscount, String city, String phone, String unionid) {
        this.userId = userId;
        this.accType = accType;
        this.regTime = regTime;
        this.noticephone = noticephone;
        this.channelId = channelId;
        this.pushId = pushId;
        this.password = password;
        this.userLevelname = userLevelname;
        this.userLevel = userLevel;
        this.username = username;
        this.balance = balance;
        this.mealDiscount = mealDiscount;
        this.headImg = headImg;
        this.nickName = nickName;
        this.sex = sex;
        this.isnew = isnew;
        this.burrencyBeans = burrencyBeans;
        this.burrencyBeansDiscount = burrencyBeansDiscount;
        this.city = city;
        this.phone = phone;
        this.unionid = unionid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getNoticephone() {
        return noticephone;
    }

    public void setNoticephone(String noticephone) {
        this.noticephone = noticephone;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLevelname() {
        return userLevelname;
    }

    public void setUserLevelname(String userLevelname) {
        this.userLevelname = userLevelname;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMealDiscount() {
        return mealDiscount;
    }

    public void setMealDiscount(double mealDiscount) {
        this.mealDiscount = mealDiscount;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public int getBurrencyBeans() {
        return burrencyBeans;
    }

    public void setBurrencyBeans(int burrencyBeans) {
        this.burrencyBeans = burrencyBeans;
    }

    public int getBurrencyBeansDiscount() {
        return burrencyBeansDiscount;
    }

    public void setBurrencyBeansDiscount(int burrencyBeansDiscount) {
        this.burrencyBeansDiscount = burrencyBeansDiscount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
