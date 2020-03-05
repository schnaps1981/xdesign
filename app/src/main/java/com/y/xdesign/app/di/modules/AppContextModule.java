package com.y.xdesign.app.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {
    private final Context context;

    public AppContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext()
    {
        return context;
    }
}
