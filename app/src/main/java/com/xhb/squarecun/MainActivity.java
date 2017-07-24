package com.xhb.squarecun;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.xhb.squarecun.base.BaseActivity;
import com.xhb.squarecun.base.BaseFragment;
import com.xhb.squarecun.ui.OneFragment;
import com.xhb.squarecun.ui.ThreeFragment;
import com.xhb.squarecun.ui.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0, false);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1, false);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2, false);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.content);
        List<BaseFragment> pagers = new ArrayList<>();
        pagers.add(new OneFragment());
        pagers.add(new TwoFragment());
        pagers.add(new ThreeFragment());
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), pagers);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    class ViewPageAdapter extends FragmentPagerAdapter {

        FragmentManager mFragmentManager;
        List<BaseFragment> mPagers;

        public ViewPageAdapter(FragmentManager fm, List<BaseFragment> pagers) {
            super(fm);
            mFragmentManager = fm;
            mPagers = pagers;
        }

        @Override
        public Fragment getItem(int position) {
            return mPagers.get(position);
        }

        @Override
        public int getCount() {
            return mPagers.size();
        }
    }

}
