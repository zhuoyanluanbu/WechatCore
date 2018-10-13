package com.entites;

public class Order extends MyObject{
    private String id ; // 订单编号
    private String uuid ; // uuid
    private long advertId = -1 ; // 广告id
    private long ticketId = -1 ; // 优惠券id
    private long userId = -1 ; // 用户id
    private String title ; // 广告标题
    private String goodsName ; // 商品名
    private String goodsDesc ; // 商品详情
    private long morePrice = -1 ; // 多的价格
    private long lessPrice = -1 ; // 少的价格
    private long payPrice = -1 ; // 用户应支付价格
    private long realPrice = -1 ; // 应结算给商户的价格
    private int ticketType = -1 ; // 券类型
    private String ticketTypeDesc ; // 券类型描述
    private int goodsType = -1 ; // 商品类型
    private String goodsTypeDesc ; // 商品类型描述
    private int multigoods = -1 ; // 0否1是是否套餐
    private String ticketEndTime ; // 优惠券截止时间
    private String releaseTime ; // 广告发布时间
    private long releaseCustomerId = -1 ; // 发布人id
    private String releaseCustomerName ; // 发布人姓名
    private String storeId ; // 商店id
    private String brandName ; // 品牌名字
    private String fullName ; // 全名
    private String storeAddress ; // 商户地址
    private String storePhone ; // 商户电话
    private String label ; // 标签
    private double storeLongitude = -1 ; // 经度
    private double storeLatitude = -1 ; // 纬度
    private long typeId = -1 ; // 商户类型id
    private String typeName ; // 商户类型名字
    private String cbdId ; // 商圈id
    private String cbdName ; // 商圈名字
    private String cbdAddress ; // 商圈地址
    private String cbdDistrict ; // 商圈所在区
    private String createTime ; // 创建时间
    private String payTime ; // 支付时间
    private String useTime ; // 使用时间
    private long scanCustomerId = -1 ; // 扫码店员id
    private int state = -1 ; // 状态
    private int del = -1 ; // 删除标志
    private String remark ; // 备注
    private String imgUrl ; // 广告图片地址

    public Order() {
    }

    public Order(String id, String uuid, long advertId, long ticketId, long userId, String title, String goodsName, String goodsDesc, long morePrice, long lessPrice, long payPrice, long realPrice, int ticketType, String ticketTypeDesc, int goodsType, String goodsTypeDesc, int multigoods, String ticketEndTime, String releaseTime, long releaseCustomerId, String releaseCustomerName, String storeId, String brandName, String fullName, String storeAddress, String storePhone, String label, double storeLongitude, double storeLatitude, long typeId, String typeName, String cbdId, String cbdName, String cbdAddress, String cbdDistrict, String createTime, String payTime, String useTime, long scanCustomerId, int state, int del, String remark, String imgUrl) {
        this.id = id;
        this.uuid = uuid;
        this.advertId = advertId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.title = title;
        this.goodsName = goodsName;
        this.goodsDesc = goodsDesc;
        this.morePrice = morePrice;
        this.lessPrice = lessPrice;
        this.payPrice = payPrice;
        this.realPrice = realPrice;
        this.ticketType = ticketType;
        this.ticketTypeDesc = ticketTypeDesc;
        this.goodsType = goodsType;
        this.goodsTypeDesc = goodsTypeDesc;
        this.multigoods = multigoods;
        this.ticketEndTime = ticketEndTime;
        this.releaseTime = releaseTime;
        this.releaseCustomerId = releaseCustomerId;
        this.releaseCustomerName = releaseCustomerName;
        this.storeId = storeId;
        this.brandName = brandName;
        this.fullName = fullName;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.label = label;
        this.storeLongitude = storeLongitude;
        this.storeLatitude = storeLatitude;
        this.typeId = typeId;
        this.typeName = typeName;
        this.cbdId = cbdId;
        this.cbdName = cbdName;
        this.cbdAddress = cbdAddress;
        this.cbdDistrict = cbdDistrict;
        this.createTime = createTime;
        this.payTime = payTime;
        this.useTime = useTime;
        this.scanCustomerId = scanCustomerId;
        this.state = state;
        this.del = del;
        this.remark = remark;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(long advertId) {
        this.advertId = advertId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public long getMorePrice() {
        return morePrice;
    }

    public void setMorePrice(long morePrice) {
        this.morePrice = morePrice;
    }

    public long getLessPrice() {
        return lessPrice;
    }

    public void setLessPrice(long lessPrice) {
        this.lessPrice = lessPrice;
    }

    public long getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(long payPrice) {
        this.payPrice = payPrice;
    }

    public long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(long realPrice) {
        this.realPrice = realPrice;
    }

    public int getTicketType() {
        return ticketType;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketTypeDesc() {
        return ticketTypeDesc;
    }

    public void setTicketTypeDesc(String ticketTypeDesc) {
        this.ticketTypeDesc = ticketTypeDesc;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsTypeDesc() {
        return goodsTypeDesc;
    }

    public void setGoodsTypeDesc(String goodsTypeDesc) {
        this.goodsTypeDesc = goodsTypeDesc;
    }

    public int getMultigoods() {
        return multigoods;
    }

    public void setMultigoods(int multigoods) {
        this.multigoods = multigoods;
    }

    public String getTicketEndTime() {
        return ticketEndTime;
    }

    public void setTicketEndTime(String ticketEndTime) {
        this.ticketEndTime = ticketEndTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public long getReleaseCustomerId() {
        return releaseCustomerId;
    }

    public void setReleaseCustomerId(long releaseCustomerId) {
        this.releaseCustomerId = releaseCustomerId;
    }

    public String getReleaseCustomerName() {
        return releaseCustomerName;
    }

    public void setReleaseCustomerName(String releaseCustomerName) {
        this.releaseCustomerName = releaseCustomerName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getStoreLongitude() {
        return storeLongitude;
    }

    public void setStoreLongitude(double storeLongitude) {
        this.storeLongitude = storeLongitude;
    }

    public double getStoreLatitude() {
        return storeLatitude;
    }

    public void setStoreLatitude(double storeLatitude) {
        this.storeLatitude = storeLatitude;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCbdId() {
        return cbdId;
    }

    public void setCbdId(String cbdId) {
        this.cbdId = cbdId;
    }

    public String getCbdName() {
        return cbdName;
    }

    public void setCbdName(String cbdName) {
        this.cbdName = cbdName;
    }

    public String getCbdAddress() {
        return cbdAddress;
    }

    public void setCbdAddress(String cbdAddress) {
        this.cbdAddress = cbdAddress;
    }

    public String getCbdDistrict() {
        return cbdDistrict;
    }

    public void setCbdDistrict(String cbdDistrict) {
        this.cbdDistrict = cbdDistrict;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public long getScanCustomerId() {
        return scanCustomerId;
    }

    public void setScanCustomerId(long scanCustomerId) {
        this.scanCustomerId = scanCustomerId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
