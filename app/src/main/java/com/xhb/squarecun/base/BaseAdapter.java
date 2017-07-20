package com.xhb.squarecun.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/20.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private int mLayoutId;
    private LayoutInflater mLayoutInflater;
    private ArrayList<T> mDatas;

    private OnItemClickListener mOnItemClickListener;

    public BaseAdapter(Context context, int layoutId, ArrayList<T> datas) {
        mContext = context;
        mLayoutId = layoutId;
        mLayoutInflater = LayoutInflater.from(mContext);
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.get(mContext, parent, mLayoutId);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        convert(holder, mDatas.get(position));
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
