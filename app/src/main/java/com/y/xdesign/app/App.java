package com.y.xdesign.app;

import android.app.Application;

import com.y.xdesign.BuildConfig;
import com.y.xdesign.app.di.components.AppComponent;
import com.y.xdesign.app.di.components.DaggerAppComponent;
import com.y.xdesign.app.di.modules.AppContextModule;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();

        initLogger();
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, @NotNull String message, Throwable t) {

                }
            });
        }
    }


    public static AppComponent getAppComponent()
    {
        return appComponent;
    }

}
