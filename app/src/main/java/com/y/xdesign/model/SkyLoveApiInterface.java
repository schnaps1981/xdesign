package com.y.xdesign.model;

import com.y.xdesign.model.datamodel.AuthPostData;
import com.y.xdesign.model.datamodel.UserAuthModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SkyLoveApiInterface {
    @POST("/v1/login/email")
    Call<UserAuthModel> userAuth(
            @Body AuthPostData data

    );
}
