package com.xhb.squarecun.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhb.squarecun.R;
import com.xhb.squarecun.base.BaseAdapter;
import com.xhb.squarecun.base.BaseFragment;
import com.xhb.squarecun.commons.MineAdapter;

import java.util.ArrayList;

/**
 *
 */
public class OneFragment extends BaseFragment {

    RecyclerView recyclerView;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        System.out.print("onCreate call ...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.print("onCreateView call ...");
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        //设置适配器
        ArrayList<String> datas = new ArrayList<>();
        datas.add("1");
        datas.add("2");
        datas.add(getString(R.string.large_text));
        MineAdapter adapter = new MineAdapter(getActivity(), R.layout.item_mine, datas);
        recyclerView.setAdapter(adapter);
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        //设置项动画
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置项点击事件
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
