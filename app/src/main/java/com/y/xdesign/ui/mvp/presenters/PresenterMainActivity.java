package com.y.xdesign.ui.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.y.xdesign.app.App;
import com.y.xdesign.navigation.Screens;
import com.y.xdesign.ui.mvp.views.MainActivityView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PresenterMainActivity extends MvpPresenter<MainActivityView> {

    @Inject
    Router router;


    @Override
    public void attachView(MainActivityView view) {
        super.attachView(view);
        App.getAppComponent().inject(this);

        router.replaceScreen(new Screens.LoginScreen());
    }

    public void onBackPressed()
    {
        router.exit();
    }
}
