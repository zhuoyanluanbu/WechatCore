package com.menu;

import com.entites.MyObject;

import java.util.List;

/**
 * Created by huyoucheng on 2018/10/8.
 */
public class FatherButton extends MyObject {

    private String name;

    private List<Button> sub_button;

    public FatherButton(String name, List<Button> sub_button) {
        this.name = name;
        this.sub_button = sub_button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }
}
