package com.y.xdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.y.xdesign.R;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.presenter.Presenter;
import com.y.xdesign.ui.adapter.PhotoListAdapter;
import com.y.xdesign.ui.view.MainActivityView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends MvpActivity implements MainActivityView {

    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.ll_enter_login)
    LinearLayout llEnterLogin;
    @BindView(R.id.ll_enter_password)
    LinearLayout llEnterPassword;
    @BindView(R.id.rv_photos)
    RecyclerView rvPhotos;
    @BindView(R.id.llListPhotos)
    LinearLayout llListPhotos;

    @InjectPresenter
    Presenter presenter;

    private PhotoListAdapter photoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        initRecyclerView();

    }

    private void initRecyclerView() {
        photoListAdapter = new PhotoListAdapter();

        StaggeredGridLayoutManager  layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        rvPhotos.setItemAnimator(null);

        rvPhotos.setHasFixedSize(true);
        rvPhotos.setLayoutManager(layoutManager);
        rvPhotos.setAdapter(photoListAdapter);
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
        llEnterLogin.setVisibility(View.VISIBLE);
        llEnterPassword.setVisibility(View.GONE);
        rvPhotos.setVisibility(View.GONE);
    }

    @Override
    public void hideLoginScreen() {
        llEnterLogin.setVisibility(View.GONE);
        llEnterPassword.setVisibility(View.GONE);
        llListPhotos.setVisibility(View.VISIBLE);

    }

    @Override
    public void showPhotos(ArrayList<PhotoModel> photosList) {
        llListPhotos.setVisibility(View.VISIBLE);
        photoListAdapter.setList(photosList);


    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void AdapterCallbackClickListener() {
        Timber.d("Item was clicked");
        //TODO передавыать позицию или сразу занчение
        presenter.itemClicked(0);
    }
}
