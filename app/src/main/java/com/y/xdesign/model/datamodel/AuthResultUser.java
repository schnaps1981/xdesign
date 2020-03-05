package com.y.xdesign.model.datamodel;


//класс user в модели аутентификационного запроса
public class AuthResultUser {
    private Integer user_id;
    private String token;
    private String name;
    private String city;
    private Integer years;
    private String photo;
    private Integer vip;
    private Integer verification;
    private Integer fb;
    private Integer vk;
    private Integer sex;


    // Getter Methods

    public Integer getUser_id() {
        return user_id;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getYears() {
        return years;
    }

    public String getPhoto() {
        return photo;
    }

    public Integer getVip() {
        return vip;
    }

    public Integer getVerification() {
        return verification;
    }

    public Integer getFb() {
        return fb;
    }

    public Integer getVk() {
        return vk;
    }

    public Integer getSex() {
        return sex;
    }

    // Setter Methods

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    public void setFb(Integer fb) {
        this.fb = fb;
    }

    public void setVk(Integer vk) {
        this.vk = vk;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
