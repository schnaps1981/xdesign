package com.y.xdesign.model;

import io.reactivex.Single;

public interface Model {
    Single<String> authUser(String login, String password);
}
