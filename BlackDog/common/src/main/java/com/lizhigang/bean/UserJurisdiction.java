package com.lizhigang.bean;

public class UserJurisdiction {
    private Integer id;

    private String userName;

    private String password;

    private String tel;

    private String individualSignature;

    private String professionaTag;

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getIndividualSignature() {
        return individualSignature;
    }

    public void setIndividualSignature(String individualSignature) {
        this.individualSignature = individualSignature == null ? null : individualSignature.trim();
    }

    public String getProfessionaTag() {
        return professionaTag;
    }

    public void setProfessionaTag(String professionaTag) {
        this.professionaTag = professionaTag == null ? null : professionaTag.trim();
    }

    public Integer getJurisdictionIdw() {
        return jurisdictionIdw;
    }

    public void setJurisdictionIdw(Integer jurisdictionIdw) {
        this.jurisdictionIdw = jurisdictionIdw;
    }
}