package com.y.xdesign.model;

import com.y.xdesign.app.App;
import com.y.xdesign.app.Constants;
import com.y.xdesign.model.api.SkyLoveApiInterface;
import com.y.xdesign.model.datamodel.AuthResultModel;
import com.y.xdesign.model.datamodel.PhotoCollectionModel;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.model.utils.AESTest;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelImpl implements Model {
    @Inject SkyLoveApiInterface skyLoveApi;
    @Inject AESTest cryptoPassword;

    public ModelImpl()
    {
        App.getAppComponent().inject(this);
    }

    @Override
    public Single<AuthResultModel> authUser(String login, String password) {
        return Single.create(emitter -> {

            RequestBody requestBodyLogin = RequestBody.create(MediaType.parse("text/plain"), login);
            RequestBody requestBodyPassword = RequestBody.create(MediaType.parse("text/plain"), cryptoPassword.encode(password));
            RequestBody requestBodyAppId = RequestBody.create(MediaType.parse("text/plain"), Constants.APP_ID);

            skyLoveApi.userAuth(requestBodyLogin, requestBodyPassword, requestBodyAppId).enqueue(new Callback<AuthResultModel>() {
                @Override
                public void onResponse(Call<AuthResultModel> call, Response<AuthResultModel> response) {
                    assert response.body() != null;

                    //обработка ошибки
                    if (!response.isSuccessful() && response.errorBody() != null)
                    {
                        try {
                            String error = response.errorBody().string();
                            emitter.onError(new Throwable("Server answer with error = " + error) );
                        } catch (IOException e) {
                            e.printStackTrace();
                            emitter.onError(e);
                        }
                    }
                    else
                    {
                        emitter.onSuccess(response.body());
                    }
                }

                @Override
                public void onFailure(Call<AuthResultModel> call, Throwable t) {
                    emitter.onError(t);
                }
            });


        });

    }

    @Override
    public Single<ArrayList<PhotoModel>> userPhotos(AuthResultModel user) {
        return Single.create(emitter -> {
           skyLoveApi.userPhotos(user.getUser().getToken(), user.getUser().getUser_id()).enqueue(new Callback<PhotoCollectionModel>() {
               @Override
               public void onResponse(Call<PhotoCollectionModel> call, Response<PhotoCollectionModel> response) {
                   if (!response.isSuccessful() && response.errorBody() != null)
                   {
                       try {
                           String error = response.errorBody().string();
                           emitter.onError(new Throwable("Server answer with error = " + error) );
                       } catch (IOException e) {
                           e.printStackTrace();
                           emitter.onError(e);
                       }
                   }
                   else
                   {
                       emitter.onSuccess(response.body().getPhotos());
                   }
               }

               @Override
               public void onFailure(Call<PhotoCollectionModel> call, Throwable t) {

               }
           });

        });
    }
}
