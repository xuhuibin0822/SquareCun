package com.xhb.squarecun.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by XHB on 2017/7/21.
 */

public class SimpleNestedScrollParent extends LinearLayout implements NestedScrollingParent {
    private static final String TAG = "SNSP";
    private NestedScrollingParentHelper parentHelper;
    private boolean addHeight;

    public SimpleNestedScrollParent(Context context) {
        super(context);
        init();
    }

    public SimpleNestedScrollParent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleNestedScrollParent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        parentHelper = new NestedScrollingParentHelper(this);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.i(TAG, "onStartNestedScroll Call... " + ((nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0));
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Log.i(TAG, "onNestedScrollAccepted Call... axes=" + axes);
        parentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(View child) {
        Log.i(TAG, "onStopNestedScroll Call...");
        parentHelper.onStopNestedScroll(child);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.i(TAG, "onNestedScroll Call... dxConsumed=" + dxConsumed + " dyConsumed=" + dyConsumed + " dxUnconsumed=" + dxUnconsumed + " dyUnconsumed=" + dyUnconsumed);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Log.i(TAG, "onNestedPreScroll Call... dx=" + dx + " dy=" + dy + " top=" + this.getTop() + " target=" + target.getScrollY());
        //处理子view传上来的事件
        //头部高度
        int headerHeight = this.getChildAt(0).getHeight();
        if (dy > 0) {
            //向上滑动
            if (Math.abs(this.getTop() - dy) <= headerHeight) {
                //header 在向上滑动的过程
                this.layout(this.getLeft(), this.getTop() - dy, this.getRight(), this.getBottom() - dy);
                if (!addHeight) {
                    //只增加一次 高度 height
                    addHeight = true;
                    ViewGroup.LayoutParams params = this.getLayoutParams();
                    params.height = headerHeight + this.getHeight();
                    this.setLayoutParams(params);
                    requestLayout();
                }
                consumed[1] += dy;
            } else {
                //当用户滑动动作太大，一次位移太大就会把parentview滑动脱离底部屏幕
                if ((this.getTop() + headerHeight) > 0) {
                    int offsetY = headerHeight + this.getTop();
                    this.layout(this.getLeft(), this.getTop() - offsetY, this.getRight(), this.getBottom() - offsetY);
                    consumed[1] += offsetY;
                }
            }
        }
        if (dy < 0) {
            //向下滑动
            if ((this.getTop() + Math.abs(dy)) <= 0) {
                //header在向下滑动的过程
                //this.gettop是负数dy也是负数所以需要+dy的绝对值
                this.layout(this.getLeft(), this.getTop() + Math.abs(dy), this.getRight(), this.getBottom() + Math.abs(dy));
                consumed[1] += dy;
            } else {
                if (this.getTop() < 0) {
                    int offsetY = Math.abs(this.getTop());
                    this.layout(this.getLeft(), this.getTop() + offsetY, this.getRight(), this.getBottom() + offsetY);
                    consumed[1] += offsetY;
                }
            }
        }
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.i(TAG, "onNestedFling Call... velocityX=" + velocityX + " velocityY=" + velocityY + " consumed=" + consumed);
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.i(TAG, "onNestedPreFling Call... velocityX=" + velocityX + " velocityY=" + velocityY);
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        Log.i(TAG, "getNestedScrollAxes Call...");
        return parentHelper.getNestedScrollAxes();
    }
}
