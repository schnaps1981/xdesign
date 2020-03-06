package com.y.xdesign.ui.adapter.base;

import android.view.View;

public interface BaseAdapterCallback<T> {
    void onItemClick(T model, View view);
    Boolean onLongClick(T model, View view);
}
