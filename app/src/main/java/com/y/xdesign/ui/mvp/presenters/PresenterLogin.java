package com.y.xdesign.ui.mvp.presenters;

import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.y.xdesign.app.App;
import com.y.xdesign.model.Model;
import com.y.xdesign.ui.mvp.views.LoginView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@InjectViewState
public class PresenterLogin extends MvpPresenter<LoginView> {

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
        getViewState().showLoginProgress();
        disposable.add(
                model.authUser(login, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(user -> model.userPhotos(user))
                        .subscribe(photos -> {
                            getViewState().hideLoginProgress();
                            getViewState().photosLoaded(photos);
                            Timber.d("user token - %s", photos);
                        }, throwable -> {
                            Timber.d("Error - %s", throwable.getLocalizedMessage());
                            getViewState().showMessage(throwable.getLocalizedMessage());
                            getViewState().hidePasswordField();
                            getViewState().hideLoginProgress();
                            getViewState().showLoginField();
                        })
        );
    }

    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
        App.getAppComponent().inject(this);
        getViewState().showLoginField();
        getViewState().hidePasswordField();
    }

    public void checkLoginField(CharSequence charSequence) {
        if (charSequence.length() > 0) {
            getViewState().enableLoginButton();
        } else {
            getViewState().disableLoginButton();
        }
    }

    public void checkPasswordField(CharSequence charSequence) {
        if (charSequence.length() > 0) {
            getViewState().enablePasswordButton();
        } else {
            getViewState().disablePasswordButton();
        }
    }
}
