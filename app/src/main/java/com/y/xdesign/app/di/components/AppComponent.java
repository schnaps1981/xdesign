package com.y.xdesign.app.di.components;

import com.y.xdesign.app.di.modules.AppContextModule;
import com.y.xdesign.app.di.modules.CompositeDisposableModule;
import com.y.xdesign.presenter.Presenter;
import com.y.xdesign.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppContextModule.class,
        CompositeDisposableModule.class
        })

public interface AppComponent {
    void inject(MainActivity activity);

    void inject(Presenter presenter);


}
