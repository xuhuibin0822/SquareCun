package com.xhb.squarecun.commons;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.xhb.squarecun.R;
import com.xhb.squarecun.base.BaseAdapter;
import com.xhb.squarecun.base.ViewHolder;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/20.
 */

public class MineAdapter extends BaseAdapter<String> {
    public MineAdapter(Context context, int layoutId, ArrayList datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, String s) {
        TextView tvName = holder.getView(R.id.tv_name);
        tvName.setText(s);
    }
}
