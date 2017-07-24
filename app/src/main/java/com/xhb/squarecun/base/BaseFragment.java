package com.xhb.squarecun.base;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.xhb.squarecun.R;

/**
 * Created by XHB on 2017/7/19.
 */

public class BaseFragment extends Fragment {
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
    }
}
