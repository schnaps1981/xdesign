package com.y.xdesign.ui.mvp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.y.xdesign.R;
import com.y.xdesign.app.App;
import com.y.xdesign.app.GlideApp;
import com.y.xdesign.ui.mvp.presenters.PresenterLogin;
import com.y.xdesign.ui.mvp.views.LoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

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

    @Inject CompositeDisposable compositeDisposable;

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
        App.getAppComponent().inject(this);

        unbinder = ButterKnife.bind(this, view);

        int radius = getActivity().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.corner_radius);
        GlideApp.with(this).load(R.drawable.background_login)
                .transform(new RoundedCorners(radius))
                .transform(new CenterCrop())
                .into(ivLoginBackground);

        compositeDisposable.add(RxTextView.textChanges(etLogin).subscribeOn(AndroidSchedulers.mainThread()).subscribe(charSequence -> {
            presenterLogin.checkLoginField(charSequence);
        }));

        compositeDisposable.add(RxTextView.textChanges(etPassword).subscribeOn(AndroidSchedulers.mainThread()).subscribe(charSequence -> {
            presenterLogin.checkPasswordField(charSequence);
        }));

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
    public void showMessage(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void enableLoginButton() {
        btnLogin.setEnabled(true);
    }

    @Override
    public void disableLoginButton() {
        btnLogin.setEnabled(false);
    }

    @Override
    public void enablePasswordButton() {
        btnPassword.setEnabled(true);
    }

    @Override
    public void disablePasswordButton() {
        btnPassword.setEnabled(false);
    }

    @Override
    public void focusPasswordEditText() {
        etPassword.requestFocus();
        etPassword.setFocusable(true);
        etPassword.setFocusableInTouchMode(true);
    }

    @Override
    public void focusLoginEditText() {
        etLogin.requestFocus();
        etLogin.setFocusable(true);
        etLogin.setFocusableInTouchMode(true);
    }

    @Override
    public void clearEditTextFields() {
        etLogin.setText("");
        etPassword.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        compositeDisposable.dispose();
    }
}
