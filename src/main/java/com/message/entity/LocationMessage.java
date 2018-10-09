package com.message.entity;

/**
 * Created by huyoucheng on 2017/5/26.
 */
public class LocationMessage extends EventMessage {

    private double latitude;
    private double longitude;
    private double precision;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public LocationMessage(){}

    public LocationMessage(double latitude, double longitude, double precision) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public LocationMessage(String event, double latitude, double longitude, double precision) {
        super(event);
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public LocationMessage(String toUserName, String fromUserName, String createTime, String msgType, String event, double latitude, double longitude, double precision) {
        super(toUserName, fromUserName, createTime, msgType, event);
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }
}
