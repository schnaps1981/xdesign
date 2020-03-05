package com.y.xdesign.app.di.modules;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class CompositeDisposableModule {

    @Provides
    public CompositeDisposable provideCompositeDisposableModule()
    {
        return new CompositeDisposable();
    }

}
