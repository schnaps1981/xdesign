package com.y.xdesign.ui.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.y.xdesign.model.datamodel.PhotoModel;

import java.util.ArrayList;


public interface LoginView extends MvpView {
    void showLoginField();
    void hideLoginField();
    void showPasswordField();
    void hidePasswordField();
    void showLoginProgress();
    void hideLoginProgress();

    @StateStrategyType(SkipStrategy.class)
    void showMessage(String message);

    void enableLoginButton();
    void disableLoginButton();
    void enablePasswordButton();
    void disablePasswordButton();

    void focusPasswordEditText();
    void focusLoginEditText();

    void clearEditTextFields();
}
