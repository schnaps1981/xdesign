package com.y.xdesign.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.y.xdesign.R;
import com.y.xdesign.model.datamodel.PhotoModel;
import com.y.xdesign.ui.adapter.base.BaseAdapter;
import com.y.xdesign.ui.adapter.base.BaseViewHolder;


public class PhotoListAdapter extends BaseAdapter<PhotoModel> {
    @NonNull
    @Override
    public BaseViewHolder<PhotoModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false));
    }
}
