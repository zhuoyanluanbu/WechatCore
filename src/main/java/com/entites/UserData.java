package com.entites;

public class UserData extends MyObject{
    private long id = -1 ; // 用户编号，t_user_info表里面的编号
    private String openId ; // 微信openID
    private String nickname ; // 昵称
    private String realName ; // 姓名
    private int gender = -1; // 性别
    private String language ; // 语言
    private String city ; // 城市
    private String province ; // 省/州
    private String country ; // 国家
    private String avatarUrl ; // 头像url
    private String phone ; // 电话
    private String channel ; // 加入渠道
    private String source ; // 加入渠道
    private String createTime ; // 创建时间
    private int state = -1 ; // 状态
    private int del = -1 ; // 删除标志
    private String remark ; // 备注
    private int userChannel=-1;//用户渠道，0微信小程序，1微信公众号
    private String userUnionId;//联合ID
    private double longitude=-1;//用户所在位置经度
    private double latitude=-1;//用户所在位置纬度
    private String userAddress;//用户所在地址

    private long inviteUser=-1;//邀请人，0表示没有人邀请，自己注册的
    private int inviteMethod=-1;//邀请方式,0微信小程序分享，1公众号二维码

    public UserData() {
    }

    public UserData(long id, String openId, String nickname, String realName, int gender, String language, String city, String province, String country, String avatarUrl, String phone, String channel, String source, String createTime, int state, int del, String remark, int userChannel, String userUnionId, double longitude, double latitude, String userAddress, long inviteUser, int inviteMethod) {
        this.id = id;
        this.openId = openId;
        this.nickname = nickname;
        this.realName = realName;
        this.gender = gender;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.channel = channel;
        this.source = source;
        this.createTime = createTime;
        this.state = state;
        this.del = del;
        this.remark = remark;
        this.userChannel = userChannel;
        this.userUnionId = userUnionId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.userAddress = userAddress;
        this.inviteUser = inviteUser;
        this.inviteMethod = inviteMethod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(int userChannel) {
        this.userChannel = userChannel;
    }

    public String getUserUnionId() {
        return userUnionId;
    }

    public void setUserUnionId(String userUnionId) {
        this.userUnionId = userUnionId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public long getInviteUser() {
        return inviteUser;
    }

    public void setInviteUser(long inviteUser) {
        this.inviteUser = inviteUser;
    }

    public int getInviteMethod() {
        return inviteMethod;
    }

    public void setInviteMethod(int inviteMethod) {
        this.inviteMethod = inviteMethod;
    }
}
