package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by gjp06 on 17.6.16.
 */
public class User {
    private String id;
    private String name;
    private String faName;
    private String phone;
    private String src;
    private String password;
    private String salt;
    private String sex;
    private String status;
    private String province;
    private String area;
    private String sign;
    private String email;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date registerTime;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date lastLoginTime;
    private Lama lama;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", faName='" + faName + '\'' +
                ", phone='" + phone + '\'' +
                ", src='" + src + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                ", province='" + province + '\'' +
                ", area='" + area + '\'' +
                ", sign='" + sign + '\'' +
                ", email='" + email + '\'' +
                ", registerTime=" + registerTime +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", lama=" + lama +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Lama getLama() {
        return lama;
    }

    public void setLama(Lama lama) {
        this.lama = lama;
    }
}
