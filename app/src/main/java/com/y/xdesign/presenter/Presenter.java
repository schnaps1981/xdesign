package com.y.xdesign.presenter;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.y.xdesign.app.App;
import com.y.xdesign.ui.view.MainActivityView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

@InjectViewState
public class Presenter extends MvpPresenter<MainActivityView> {
    @Inject CompositeDisposable disposable;

    public void loginButtonPressed(View view)
    {
        getViewState().hideLoginField();
        getViewState().showPasswordField();
    }

    public void passwordButtonPressed(View view, String login, String password)
    {
        //начать цепочку запросов к серверу
        Timber.d("Начать запрос");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

    @Override
    public void attachView(MainActivityView view) {
        super.attachView(view);

        App.getAppComponent().inject(this);
        getViewState().showLoginField();

    }
}
