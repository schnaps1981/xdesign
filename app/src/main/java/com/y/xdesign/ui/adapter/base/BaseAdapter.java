package com.y.xdesign.ui.adapter.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<P> extends RecyclerView.Adapter<BaseViewHolder<P>> {
    protected ArrayList<P> mDataList = new ArrayList<P>();
    private BaseAdapterCallback<P> mCallback = null;
    public Boolean hasItems = false;

    public void attachCallback(BaseAdapterCallback<P> callback) {
        this.mCallback = callback;
    }

    public void detachCallback() {
        this.mCallback = null;
    }

    public void setList(List<P> dataList) {
        mDataList.addAll(dataList);
        hasItems = true;
        notifyDataSetChanged();
    }

    public void addItem(P newItem) {
        mDataList.add(newItem);
        notifyItemInserted(mDataList.size() - 1);
    }

    public void addItemToTop(P newItem) {
        mDataList.add(0, newItem);
        notifyItemInserted(0);
    }

    public void updateItems(List<P> itemsList) {
        mDataList.clear();
        setList(itemsList);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<P> holder, int position) {
        holder.bind(mDataList.get(position));

        holder.itemView.setOnClickListener(view ->  {
            mCallback.onItemClick(mDataList.get(position), holder.itemView);
        });

        holder.itemView.setOnLongClickListener(view -> {
            if (mCallback != null) {
                mCallback.onLongClick(mDataList.get(position), holder.itemView);
                return true;
            }
            return false;
        });
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
