package com.entites;

/**
 * Created with IntelliJ IDEA.
 * User: Dave Liu
 * Date: 15-11-8
 * Time: 下午9:25
 * ajax请求返回数据
 */
public class SimpleResponseBody<T> {
    private ReInfo reInfo;
    private T entity;

    public SimpleResponseBody() {
    }

    public SimpleResponseBody(ReInfo reInfo){
        this.reInfo = reInfo;
    }

    public SimpleResponseBody(ReInfo reInfo, T entity) {
        this.reInfo = reInfo;
        this.entity = entity;
    }

    public ReInfo getReInfo() {
        return reInfo;
    }

    public void setReInfo(ReInfo reInfo) {
        this.reInfo = reInfo;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "SimpleResponseBody{" +
                "reInfo=" + reInfo +
                ", entity=" + entity +
                '}';
    }
}
