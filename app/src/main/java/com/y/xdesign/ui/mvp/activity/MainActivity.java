package com.y.xdesign.ui.mvp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.y.xdesign.R;
import com.y.xdesign.app.App;
import com.y.xdesign.ui.mvp.presenters.PresenterMainActivity;
import com.y.xdesign.ui.mvp.views.MainActivityView;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.pure.AppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class MainActivity extends MvpActivity implements  MainActivityView {

    @Inject NavigatorHolder navigatorHolder;

    @InjectPresenter
    PresenterMainActivity presenterMainActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private Navigator navigator = new AppNavigator(this, getFragmentManager(), R.id.frame)
    {
        @Override
        public void applyCommands(@NotNull Command[] commands) {
            super.applyCommands(commands);
        }
    };

    @Override
    public void onBackPressed() {
        presenterMainActivity.onBackPressed();
    }
}
