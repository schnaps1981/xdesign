package com.y.xdesign.app.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.y.xdesign.app.Constants;
import com.y.xdesign.model.SkyLoveApiInterface;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    @Provides
    SkyLoveApiInterface provideNewsAPIInterface(Retrofit retrofit) {
        return retrofit.create(SkyLoveApiInterface.class);
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }


}
