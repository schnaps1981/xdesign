package com.y.xdesign.ui.mvp.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.y.xdesign.R;
import com.y.xdesign.app.GlideApp;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.mvp.presenters.PresenterLogin;
import com.y.xdesign.ui.mvp.fragments.interfaces.OnFragmentLoginListener;
import com.y.xdesign.ui.mvp.views.LoginView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FragmentLogin extends MvpFragment implements LoginView {

    @BindView(R.id.iv_login_background) ImageView ivLoginBackground;

    @BindView(R.id.et_login) EditText etLogin;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.rl_enter_login) RelativeLayout rlEnterLogin;
    @BindView(R.id.rl_enter_password)RelativeLayout rlEnterPassword;
    @BindView(R.id.pb_login) ProgressBar pbLogin;
    @BindView(R.id.btn_login_ok) Button btnLogin;
    @BindView(R.id.btn_password_ok) Button btnPassword;

    @InjectPresenter(type = PresenterType.WEAK)
    PresenterLogin presenterLogin;

    private OnFragmentLoginListener onFragmentLoginListener;
    private Unbinder unbinder;

    public static FragmentLogin getInstance() {
        return new FragmentLogin();
    }

    @OnClick({R.id.btn_login_ok})
    public void onLoginButtonPressed(View view) {
        presenterLogin.loginButtonPressed(view);
    }

    @OnClick(R.id.btn_password_ok)
    public void onPasswordButtonPressed(View view) {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        presenterLogin.passwordButtonPressed(view, login, password);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this, view);

        GlideApp.with(this).load(R.drawable.background_login).fitCenter().into(ivLoginBackground);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_login, container, false);
    }

    @Override
    public void showLoginField() {
        rlEnterLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginField() {
        rlEnterLogin.setVisibility(View.GONE);
    }

    @Override
    public void showPasswordField() {
        rlEnterPassword.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePasswordField() {
        rlEnterPassword.setVisibility(View.GONE);
    }

    @Override
    public void showLoginProgress() {
        btnPassword.setEnabled(false);
        btnPassword.setVisibility(View.GONE);
        pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginProgress() {
        btnPassword.setEnabled(true);
        btnPassword.setVisibility(View.VISIBLE);
        pbLogin.setVisibility(View.GONE);
    }

    @Override
    public void photosLoaded(ArrayList<PhotoModel> photosList) {
        onFragmentLoginListener.getPhotosList(photosList);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            if (activity instanceof OnFragmentLoginListener)
                onFragmentLoginListener = (OnFragmentLoginListener) activity;
            else
                throw new RuntimeException(activity.toString()
                        + " должен реализовывать интерфейс OnFragmentLoginListener");
        }
    }

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentLoginListener)
            onFragmentLoginListener = (OnFragmentLoginListener) context;
        else
            throw new RuntimeException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentLoginListener");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
