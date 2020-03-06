package com.y.xdesign.model;

import com.y.xdesign.app.App;
import com.y.xdesign.model.Model;
import com.y.xdesign.model.api.SkyLoveApiInterface;
import com.y.xdesign.model.datamodel.AuthPostDataModel;
import com.y.xdesign.model.datamodel.AuthResultModel;
import com.y.xdesign.model.utils.AESTest;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModelImpl implements Model {
    @Inject SkyLoveApiInterface skyLoveApi;
    @Inject AuthPostDataModel authPostDataModel;
    @Inject AESTest cryptoPassword;

    public ModelImpl()
    {
        App.getAppComponent().inject(this);
    }

    @Override
    public Single<String> authUser(String login, String password) {
        return Single.create(emitter -> {


            authPostDataModel.setEmail(login);
            authPostDataModel.setPassword(cryptoPassword.encode(password).trim());

            skyLoveApi.userAuth(authPostDataModel).enqueue(new Callback<AuthResultModel>() {
                @Override
                public void onResponse(Call<AuthResultModel> call, Response<AuthResultModel> response) {
                    assert response.body() != null;
                    Integer error = response.body().getError();
                    if (error == 0)
                        emitter.onSuccess(response.body().getUser().getToken());
                    else
                        emitter.onError(new Throwable("Server answer with error = " + error));

                }

                @Override
                public void onFailure(Call<AuthResultModel> call, Throwable t) {
                    emitter.onError(t);
                }
            });


        });

    }
}
