package com.menu;

import com.entites.MyObject;
import com.util.WechatRequests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class MenuCreater extends MyObject{

    private List button = new ArrayList<>();

    public MenuCreater(List button) {
        this.button = button;
    }

    public List getButton() {
        return button;
    }

    public void setButton(List button) {
        this.button = button;
    }

    public MenuCreater(){
        List<Button> leftBtns = new ArrayList<>();
        Button left1 = new MiniprogramButton("我是商家","https://www.wjx.top/jq/28896672.aspx","wxe85f70c197fb3d52","pages/index/index");
        Button left2 = new MiniprogramButton("我是用户","https://www.wjx.top/jq/28896672.aspx","wx5f6c2f944a152229","pages/index/index");
        String bussinessAppid = "wx823003078e23f3b3";
        leftBtns.add(left1);
        leftBtns.add(left2);
        FatherButton fatherButtonLeft = new FatherButton("小程序",leftBtns);

        List<Button> centerBtns = new ArrayList<>();
        Button cen1 = new ClickButton("联系方式","CONTACT_US");
        Button cen2 = new ClickButton("产品介绍","PRODUCT_INTRODUCTION");
        Button cen3 = new ViewButton("问题反馈","https://www.wjx.top/jq/28896672.aspx");
        centerBtns.add(cen1);
        centerBtns.add(cen2);
        centerBtns.add(cen3);
        FatherButton fatherButtonCenter = new FatherButton("关于我们",centerBtns);


        this.button.add(fatherButtonLeft);
        this.button.add(fatherButtonCenter);

        String json = this.toJson();

        System.out.println(json);

        WechatRequests.createMenu(json,WechatRequests.getAccessTokenAndTicket().getToken());
    }

    public static void main(String[] args) {
        new MenuCreater();
    }

}
