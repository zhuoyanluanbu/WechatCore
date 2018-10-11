package com.entites;

/**
 * Created by huyoucheng on 2017/4/7.
 */
public class QrActionInfo extends MyObject {

    private QrScene scene;

    public QrScene getScene() {
        return scene;
    }

    public void setScene(QrScene scene) {
        this.scene = scene;
    }

    public QrActionInfo() {
    }

    public QrActionInfo(QrScene scene) {
        this.scene = scene;
    }
}
