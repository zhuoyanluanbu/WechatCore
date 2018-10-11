package com.entites;

/**
 * Created with IntelliJ IDEA.
 * User:
 * Date:
 * Time:
 * To change this template use File | Settings | File Templates.
 */
public class AccountData {

    private long id=-1;//自增长编号
    private long userId=-1;//用户ID
    private int userBalance=-1;//用户余额，扩大100倍存储,也就是保留2位小数

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }



    public AccountData() {
    }

    public AccountData(long id, long userId, int userBalance) {
        this.id = id;
        this.userId = userId;
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "id=" + id +
                ", userId=" + userId +
                ", userBalance=" + userBalance +
                '}';
    }
}
