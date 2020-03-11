package com.y.xdesign.app.di.components;

import com.y.xdesign.app.di.modules.AESTestModule;
import com.y.xdesign.app.di.modules.AppContextModule;
import com.y.xdesign.app.di.modules.CircularProgressDrawableModule;
import com.y.xdesign.app.di.modules.CompositeDisposableModule;
import com.y.xdesign.app.di.modules.ModelModule;
import com.y.xdesign.app.di.modules.OkHttpClientModule;
import com.y.xdesign.app.di.modules.RetrofitModule;
import com.y.xdesign.model.ModelImpl;
import com.y.xdesign.ui.adapter.PhotoViewHolder;
import com.y.xdesign.ui.mvp.activity.MainActivity;
import com.y.xdesign.ui.mvp.presenters.PresenterLogin;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppContextModule.class,
        CompositeDisposableModule.class,
        OkHttpClientModule.class,
        RetrofitModule.class,
        ModelModule.class,
        AESTestModule.class,
        CircularProgressDrawableModule.class
})

public interface AppComponent {

    void inject(MainActivity activity);

    void inject(PresenterLogin presenter);

    void inject(ModelImpl model);

    void inject(PhotoViewHolder holder);
}
