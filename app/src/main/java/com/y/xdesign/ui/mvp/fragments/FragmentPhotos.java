package com.y.xdesign.ui.mvp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.y.xdesign.R;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.adapter.PhotoListAdapter;
import com.y.xdesign.ui.adapter.base.BaseAdapterCallback;
import com.y.xdesign.ui.mvp.presenters.PresenterPhotos;
import com.y.xdesign.ui.mvp.views.PhotosView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import timber.log.Timber;

public class FragmentPhotos extends MvpFragment implements PhotosView {

    @BindView(R.id.rv_photos)
    RecyclerView rvPhotos;

    @InjectPresenter(type = PresenterType.WEAK)
    PresenterPhotos presenterPhotos;

    private static final String BUNDLE_PHOTOS_LIST_KEY = "photos_list";
    private ArrayList<PhotoModel> photosList = new ArrayList<>();
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_photos, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(BUNDLE_PHOTOS_LIST_KEY)) {
            photosList.addAll(getArguments().getParcelableArrayList(BUNDLE_PHOTOS_LIST_KEY));
        }

        unbinder = ButterKnife.bind(this, view);
        initRecyclerView();
    }

    public static FragmentPhotos getInstance(ArrayList<PhotoModel> photosList) {
        FragmentPhotos fragment = new FragmentPhotos();
        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList(BUNDLE_PHOTOS_LIST_KEY, photosList);
        fragment.setArguments(arguments);
        return fragment;
    }

    private void initRecyclerView() {
        PhotoListAdapter photoListAdapter = new PhotoListAdapter();

        photoListAdapter.setList(photosList);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        rvPhotos.setItemAnimator(null);

        rvPhotos.setHasFixedSize(true);
        rvPhotos.setLayoutManager(layoutManager);
        rvPhotos.setAdapter(photoListAdapter);

        photoListAdapter.attachCallback(photoClickListener);
    }

    @OnClick(R.id.ib_close)
    public void onClosePhotosPressed(View view)
    {
        presenterPhotos.closePhotosList();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), "photo_id: " + message, Toast.LENGTH_SHORT).show();
    }

    BaseAdapterCallback<PhotoModel> photoClickListener = new BaseAdapterCallback<PhotoModel>() {
        @Override
        public void onItemClick(PhotoModel model, View view) {
            Timber.d("Item was clicked");
            presenterPhotos.itemClicked(model.getPhotoId());
        }

        @Override
        public Boolean onLongClick(PhotoModel model, View view) {
            return false;
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
