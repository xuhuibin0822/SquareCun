package com.xhb.squarecun.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhb.squarecun.R;
import com.xhb.squarecun.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends BaseFragment {


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

}
