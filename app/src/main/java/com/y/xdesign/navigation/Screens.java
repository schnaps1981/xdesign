package com.y.xdesign.navigation;

import android.app.Fragment;

import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.mvp.fragments.FragmentLogin;
import com.y.xdesign.ui.mvp.fragments.FragmentPhotos;

import java.util.ArrayList;

import ru.terrakok.cicerone.android.pure.AppScreen;

public class Screens {
    public static final class LoginScreen extends AppScreen {
        @Override
        public Fragment getFragment() {
            return FragmentLogin.getInstance();
        }
    }

    public static final class PhotosScreen extends AppScreen {
        private ArrayList<PhotoModel> photos;

        public PhotosScreen(ArrayList<PhotoModel> photos) {
            this.photos = photos;
        }

        @Override
        public Fragment getFragment() {
            return FragmentPhotos.getInstance(photos);
        }
    }

}
