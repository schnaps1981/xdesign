package com.y.xdesign.presenter;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.y.xdesign.app.App;
import com.y.xdesign.model.Model;
import com.y.xdesign.ui.view.MainActivityView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@InjectViewState
public class Presenter extends MvpPresenter<MainActivityView> {
    @Inject
    CompositeDisposable disposable;
    @Inject
    Model model;

    public void loginButtonPressed(View view) {
        getViewState().hideLoginField();
        getViewState().showPasswordField();
    }

    public void passwordButtonPressed(View view, String login, String password) {
        //начать цепочку запросов к серверу
        Timber.d("Начать запрос");
        disposable.add(
                model.authUser(login, password)
                        .observeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .flatMap(user -> model.userPhotos(user))
                        .subscribe((photos, throwable) -> {
                            if (throwable == null)
                                Timber.d("user token - %s", photos);
                            else
                                Timber.d("Error - %s", throwable.getLocalizedMessage());
                        })
        );
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
