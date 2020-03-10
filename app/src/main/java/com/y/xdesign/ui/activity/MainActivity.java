package com.y.xdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.bumptech.glide.request.target.Target;
import com.y.xdesign.R;
import com.y.xdesign.app.GlideApp;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.presenter.Presenter;
import com.y.xdesign.ui.adapter.PhotoListAdapter;
import com.y.xdesign.ui.adapter.base.BaseAdapter;
import com.y.xdesign.ui.adapter.base.BaseAdapterCallback;
import com.y.xdesign.ui.view.MainActivityView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends MvpActivity implements MainActivityView {

    @BindView(R.id.et_login) EditText etLogin;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.rl_login_screen) RelativeLayout rlLoginScreen;
    @BindView(R.id.rl_photos_screen) RelativeLayout rlPhotosScreeen;
    @BindView(R.id.rv_photos) RecyclerView rvPhotos;
    @BindView(R.id.rl_enter_login) RelativeLayout rlEnterLogin;
    @BindView(R.id.rl_enter_password)RelativeLayout rlEnterPassword;
    @BindView(R.id.pb_login) ProgressBar pbLogin;
    @BindView(R.id.btn_login_ok) Button btnLogin;
    @BindView(R.id.btn_password_ok) Button btnPassword;

    @BindView(R.id.iv_login_background) ImageView ivLoginBackground;


    @InjectPresenter
    Presenter presenter;

    private PhotoListAdapter photoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initRecyclerView();

        loadBackground();
    }

    private void loadBackground() {
        GlideApp.with(this).load(R.drawable.background_login).override(Target.SIZE_ORIGINAL).into(ivLoginBackground);
    }

    private void initRecyclerView() {
        photoListAdapter = new PhotoListAdapter();

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        rvPhotos.setItemAnimator(null);

        rvPhotos.setHasFixedSize(true);
        rvPhotos.setLayoutManager(layoutManager);
        rvPhotos.setAdapter(photoListAdapter);

        photoListAdapter.attachCallback(photoClickListener);
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

    @OnClick(R.id.ib_close)
    public void onClosePhotosPressed(View view)
    {
        presenter.photosClosed();
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
    public void showLoginScreen() {
        rlLoginScreen.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginScreen() {
        rlLoginScreen.setVisibility(View.GONE);
    }

    @Override
    public void showPhotosScreen() {
        rlPhotosScreeen.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePhotosScreen() {
        rlPhotosScreeen.setVisibility(View.GONE);
    }

    @Override
    public void showPhotos(ArrayList<PhotoModel> photosList) {
        photoListAdapter.setList(photosList);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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


    BaseAdapterCallback<PhotoModel> photoClickListener = new BaseAdapterCallback<PhotoModel>() {
        @Override
        public void onItemClick(PhotoModel model, View view) {
            Timber.d("Item was clicked");
            presenter.itemClicked(model.getPhotoId());
        }

        @Override
        public Boolean onLongClick(PhotoModel model, View view) {
            return false;
        }
    };

}
