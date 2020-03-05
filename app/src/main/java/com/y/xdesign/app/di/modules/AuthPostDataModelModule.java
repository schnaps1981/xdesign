package com.y.xdesign.app.di.modules;

import com.y.xdesign.model.datamodel.AuthPostDataModel;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthPostDataModelModule {
    @Provides
    public AuthPostDataModel provideAuthPostDataModel()
    {
        return new AuthPostDataModel();
    }
}
