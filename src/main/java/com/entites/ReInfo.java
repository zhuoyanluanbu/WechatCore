package com.entites;

/**
 * Created by dave_suwei on 2018/4/17.
 */
public class ReInfo {
    private int recode;
    private String remsg;

    public ReInfo() {
    }

    public ReInfo(int recode, String remsg) {
        this.recode = recode;
        this.remsg = remsg;
    }

    public int getRecode() {
        return recode;
    }

    public void setRecode(int recode) {
        this.recode = recode;
    }

    public String getRemsg() {
        return remsg;
    }

    public void setRemsg(String remsg) {
        this.remsg = remsg;
    }

    @Override
    public String toString() {
        return "ReInfo{" +
                "recode=" + recode +
                ", remsg='" + remsg + '\'' +
                '}';
    }
}
