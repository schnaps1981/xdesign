package com.y.xdesign.model.api;

import com.y.xdesign.model.datamodel.AuthResultModel;
import com.y.xdesign.model.datamodel.PhotoCollectionModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface SkyLoveApiInterface {
    //Авторизация
    @Multipart
    @Headers({
            "DeviceID: test1234",
            "X-sklapp-version: Android/test",
            "X-sklapp-lang: ru"
    })
    @POST("/v1/login/email")
    Call<AuthResultModel> userAuth(
            @Part("email") RequestBody email,
            @Part("password") RequestBody password,
            @Part("app_id") RequestBody app_id);

    //Получение фото
    @Headers({
            "DeviceID: test1234",
            "X-sklapp-version: Android/test",
            "X-sklapp-lang: ru"
    })
    @GET("/v1/users/photos")
    Call<PhotoCollectionModel> userPhotos(
            @Header("authentication") String accessToken,
            @Query("user_id") Integer user_id);
}
