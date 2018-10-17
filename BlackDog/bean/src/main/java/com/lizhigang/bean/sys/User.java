package com.lizhigang.bean.sys;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户表
 * @author lizhigang
 */
public class User {
    private Integer id;

    private String userName;

    private String password;

    private String tel;

    private String introduce;

    private String registerTime;

    private String labelIdw;

    private Integer jurisdictionIdw;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLabelIdw() {
        return labelIdw;
    }

    public void setLabelIdw(String labelIdw) {
        this.labelIdw = labelIdw;
    }

    public Integer getJurisdictionIdw() {
        return jurisdictionIdw;
    }

    public void setJurisdictionIdw(Integer jurisdictionIdw) {
        this.jurisdictionIdw = jurisdictionIdw;
    }

}