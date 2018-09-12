package com.hong.widgetstyle.bean;

/**
 * Created by root on 2018/9/10.
 */

public class TypleBean {
    private String title;
    private int type;
    public TypleBean(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}
