package com.entites;

/**
 * Created by huyoucheng on 2017/4/7.
 */
public class QrForeverScene extends QrScene {

    private String scene_str;

    public String getScene_str() {
        return scene_str;
    }

    public void setScene_str(String scene_str) {
        this.scene_str = scene_str;
    }

    public QrForeverScene() {
    }

    public QrForeverScene(String scene_str) {
        this.scene_str = scene_str;
    }
}
