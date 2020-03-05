package com.y.xdesign.app.di.modules;

import com.y.xdesign.model.utils.AESTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AESTestModule {
    @Provides
    @Singleton
    AESTest provideAESTest()
    {
        return new AESTest();
    }
}
