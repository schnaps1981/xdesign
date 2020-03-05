package com.y.xdesign.model.datamodel;

//Модель для отправки аутентификацоинного запроса
public class AuthPostDataModel {
    private String email;
    private String password;
    private String app_id = "test";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
