package com.y.xdesign.model.api;

import com.y.xdesign.model.datamodel.AuthPostDataModel;
import com.y.xdesign.model.datamodel.AuthResultModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SkyLoveApiInterface {
    @Headers({
            "DeviceID: test1234",
            "X-sklapp-version: Android/test",
            "X-sklapp-lang: ru"
    })
    @POST("/v1/login/email")
    Call<AuthResultModel> userAuth(
            @Body AuthPostDataModel data
    );
}
