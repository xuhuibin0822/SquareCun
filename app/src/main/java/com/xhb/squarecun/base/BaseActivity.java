package com.xhb.squarecun.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.xhb.squarecun.R;

/**
 * Created by XHB on 2017/7/19.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_left_in, R.anim.anim_right_out);
    }
}
