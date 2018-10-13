package com.entites;

/**
 * Created by huyoucheng on 2018/10/11.
 */
public class DetailAddress extends MyObject {
    private String formatted_address;
    private String district;//区
    private String province;//省
    private String city;//市
    private String street;//街道
    private String street_number;//门牌号

    private double lat;
    private double lng;



    public DetailAddress(String formatted_address, String district, String province, String city) {
        this.formatted_address = formatted_address;
        this.district = district;
        this.province = province;
        this.city = city;
    }


    public DetailAddress() {
    }

    public DetailAddress(String formatted_address, String district, String province, String city, String street, String street_number,double lat,double lng) {
        this.formatted_address = formatted_address;
        this.district = district;
        this.province = province;
        this.city = city;
        this.street = street;
        this.street_number = street_number;
        this.lat = lat;
        this.lng = lng;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

