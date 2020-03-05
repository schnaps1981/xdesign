package com.y.xdesign.model.datamodel;

//Модель ответа аутентификационного запроса
public class AuthResultModel {
        AuthResultUser UserObject;
        Integer error;

        // Getter Methods

        public AuthResultUser getUser() {
            return UserObject;
        }

        public Integer getError() {
            return error;
        }

        // Setter Methods

        public void setUser(AuthResultUser userObject) {
            this.UserObject = userObject;
        }

        public void setError(Integer error) {
            this.error = error;
        }
    }

    