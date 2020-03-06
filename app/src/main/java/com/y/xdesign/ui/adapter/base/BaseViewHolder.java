package com.y.xdesign.ui.adapter.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{
    public abstract void bind(T model);

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}


