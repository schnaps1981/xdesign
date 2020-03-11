package com.y.xdesign.ui.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.y.xdesign.model.datamodel.PhotoModel;

import java.util.ArrayList;

public interface LoginView extends MvpView {
    void showLoginField();
    void hideLoginField();
    void showPasswordField();
    void hidePasswordField();
    void showLoginProgress();
    void hideLoginProgress();
    void photosLoaded(ArrayList<PhotoModel> photosList);

}
