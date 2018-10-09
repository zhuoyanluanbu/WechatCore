package com.entites;

/**
 * Created by huyoucheng on 2017/5/31.
 */
public class WechatTokenAndTicket extends MyObject{

    private String token;
    private int expiresIn;
    private String ticket;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public WechatTokenAndTicket() {
    }

    public WechatTokenAndTicket(String token, int expiresIn, String ticket) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.ticket = ticket;
    }
}
