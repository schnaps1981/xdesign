package com.y.xdesign.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.y.xdesign.R;
import com.y.xdesign.app.GlideApp;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.adapter.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoViewHolder extends BaseViewHolder<PhotoModel> {
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;


    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(PhotoModel model) {



        GlideApp
                .with(itemView.getContext())
                .load(model.getPrew())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .error(R.drawable.ic_error_outline_black_24dp)
                .into(ivPhoto);
    }
}
