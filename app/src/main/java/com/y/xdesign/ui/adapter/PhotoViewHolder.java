package com.y.xdesign.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.y.xdesign.R;
import com.y.xdesign.app.App;
import com.y.xdesign.app.GlideApp;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.adapter.base.BaseViewHolder;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoViewHolder extends BaseViewHolder<PhotoModel> {
    @BindView(R.id.iv_photo) ImageView ivPhoto;

    @Inject CircularProgressDrawable circularProgressDrawable;


    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        App.getAppComponent().inject(this);
    }

    @Override
    public void bind(PhotoModel model) {

        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        GlideApp
                .with(itemView.getContext())
                .load(model.getPrew())
                .placeholder(circularProgressDrawable)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_error_outline_black_24dp)
                .into(ivPhoto);
    }
}
