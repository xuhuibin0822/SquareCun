package com.xhb.squarecun.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhb.squarecun.R;
import com.xhb.squarecun.base.BaseFragment;

public class OneFragment extends BaseFragment {

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
    public void onDetach() {
        super.onDetach();
    }
}
