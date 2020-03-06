package com.y.xdesign.model.datamodel;

//Модель ответа аутентификационного запроса
public class AuthResultModel {
        private AuthResultUser user;
        private Integer error;

        // Getter Methods

        public AuthResultUser getUser() {
            return user;
        }

        public Integer getError() {
            return error;
        }

        // Setter Methods

        public void setUser(AuthResultUser user) {
            this.user = user;
        }

        public void setError(Integer error) {
            this.error = error;
        }
    }

    