package com.y.xdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.y.xdesign.R;
import com.y.xdesign.presenter.Presenter;
import com.y.xdesign.ui.view.MainActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity implements MainActivityView {

    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.ll_enter_login)
    LinearLayout llEnterLogin;
    @BindView(R.id.ll_enter_password)
    LinearLayout llEnterPassword;

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login_ok})
    public void onLoginButtonPressed(View view) {
        presenter.loginButtonPressed(view);
    }

    @OnClick(R.id.btn_password_ok)
    public void onPasswordButtonPressed(View view) {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        presenter.passwordButtonPressed(view, login, password);
    }

    @Override
    public void showLoginField() {
        llEnterLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginField() {
        llEnterLogin.setVisibility(View.GONE);
    }

    @Override
    public void showPasswordField() {
        llEnterPassword.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePasswordField() {
        llEnterPassword.setVisibility(View.GONE);
    }

    @Override
    public void showLoginScreen() {

    }

    @Override
    public void hideLoginScreen() {

    }
}
