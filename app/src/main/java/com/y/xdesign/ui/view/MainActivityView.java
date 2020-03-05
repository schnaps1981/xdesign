package com.y.xdesign.ui.view;

import com.arellomobile.mvp.MvpView;

public interface MainActivityView extends MvpView {
    void showLoginField();
    void hideLoginField();
    void showPasswordField();
    void hidePasswordField();
    void showLoginScreen();
    void hideLoginScreen();
}
