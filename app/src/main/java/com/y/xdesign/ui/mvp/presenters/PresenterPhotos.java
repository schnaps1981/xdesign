package com.y.xdesign.ui.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.y.xdesign.app.App;
import com.y.xdesign.navigation.Screens;
import com.y.xdesign.ui.mvp.views.PhotosView;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class PresenterPhotos extends MvpPresenter<PhotosView> {
    @Inject
    Router router;

    @Override
    public void attachView(PhotosView view) {
        super.attachView(view);
        App.getAppComponent().inject(this);
    }

    public void itemClicked(Integer itemID)
    {
        getViewState().showToast(itemID.toString());
    }

    public void closePhotosList() {
        router.backTo(new Screens.LoginScreen());
    }
}
