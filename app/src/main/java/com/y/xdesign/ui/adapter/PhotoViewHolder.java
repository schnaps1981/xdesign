package com.y.xdesign.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
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

        ivPhoto.layout(0,0,0,0);

        GlideApp
                .with(itemView.getContext())
                .load(model.getPrew())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_error_outline_black_24dp)
                .override(Target.SIZE_ORIGINAL)
                .into(ivPhoto);
    }
}
