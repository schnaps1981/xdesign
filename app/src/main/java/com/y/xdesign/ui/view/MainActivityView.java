package com.y.xdesign.ui.view;

import com.arellomobile.mvp.MvpView;
import com.y.xdesign.model.datamodel.PhotoModel;

import java.util.ArrayList;

public interface MainActivityView extends MvpView {
    void showLoginField();
    void hideLoginField();
    void showPasswordField();
    void hidePasswordField();
    void showLoginScreen();
    void hideLoginScreen();
    void showPhotos(ArrayList<PhotoModel> photosList);
    void showToast(String message);
}
