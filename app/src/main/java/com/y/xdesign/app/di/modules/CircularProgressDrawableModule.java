package com.y.xdesign.app.di.modules;

import android.content.Context;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import dagger.Module;
import dagger.Provides;

@Module
public class CircularProgressDrawableModule {
    @Provides
    CircularProgressDrawable providesCircularProgressDrawable(Context context)
    {
        return new CircularProgressDrawable(context);
    }
}
