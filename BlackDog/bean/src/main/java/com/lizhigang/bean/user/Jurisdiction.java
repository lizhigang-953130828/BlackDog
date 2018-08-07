package com.lizhigang.bean.user;

public class Jurisdiction {
    private Integer id;

    private String jurisdictionname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJurisdictionname() {
        return jurisdictionname;
    }

    public void setJurisdictionname(String jurisdictionname) {
        this.jurisdictionname = jurisdictionname == null ? null : jurisdictionname.trim();
    }
}