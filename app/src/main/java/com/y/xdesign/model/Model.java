package com.y.xdesign.model;

import com.y.xdesign.model.datamodel.AuthResultModel;
import com.y.xdesign.model.datamodel.PhotoModel;

import java.util.ArrayList;

import io.reactivex.Single;

public interface Model {
    Single<AuthResultModel> authUser(String login, String password);
    Single<ArrayList<PhotoModel>> userPhotos(AuthResultModel user);
}
