package com.entites;

/**
 * Created by huyoucheng on 2017/4/7.
 */
public class QrTempScene extends QrScene {
    private int scene_id;

    public int getScene_id() {
        return scene_id;
    }

    public void setScene_id(int scene_id) {
        this.scene_id = scene_id;
    }

    public QrTempScene() {
    }

    public QrTempScene(int scene_id) {
        this.scene_id = scene_id;
    }
}
