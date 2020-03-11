package com.y.xdesign.ui.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.y.xdesign.ui.mvp.views.PhotosView;

@InjectViewState
public class PresenterPhotos extends MvpPresenter<PhotosView> {

    public void itemClicked(Integer itemID)
    {
        getViewState().showToast(itemID.toString());
    }
}
