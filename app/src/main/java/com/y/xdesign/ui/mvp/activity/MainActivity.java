package com.y.xdesign.ui.mvp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpActivity;
import com.y.xdesign.R;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.mvp.fragments.FragmentLogin;
import com.y.xdesign.ui.mvp.fragments.FragmentPhotos;
import com.y.xdesign.ui.mvp.fragments.interfaces.OnFragmentLoginListener;
import com.y.xdesign.ui.mvp.fragments.interfaces.OnFragmentPhotosListener;

import java.util.ArrayList;

import timber.log.Timber;

public class MainActivity extends MvpActivity implements OnFragmentLoginListener, OnFragmentPhotosListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, FragmentLogin.getInstance())
                .commit();
    }

    @Override
    public void getPhotosList(ArrayList<PhotoModel> photosList) {
        Timber.d("Получили фоток, шт %s", photosList.size());
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, FragmentPhotos.getInstance(photosList))
                .commit();
    }

    @Override
    public void closePhotosList() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, FragmentLogin.getInstance())
                .commit();
    }
}
