package com.y.xdesign.app.di.modules;

import com.y.xdesign.model.Model;
import com.y.xdesign.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    @Provides
    @Singleton
    public Model provideModel()
    {
        return new ModelImpl();
    }

}
