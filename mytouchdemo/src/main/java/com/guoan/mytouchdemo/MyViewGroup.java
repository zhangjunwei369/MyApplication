package com.guoan.mytouchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * USER: 张军伟
 * DATA: 2018/1/5 0005
 * TIME: 上午 9:20
 */

public class MyViewGroup extends ViewGroup {

    private View mChildAt;

    public MyViewGroup(Context context) {
        this(context, null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mChildAt = getChildAt(0);
        mChildAt.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mChildAt.layout(l, t, r, b);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("Tag", "MyViewGroup            dispatchTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("Tag", "MyViewGroup                 按下");
                break;

            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("Tag", "MyViewGroup            onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("Tag", "MyViewGroup                 按下");
                return super.onInterceptTouchEvent(ev);
            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("Tag", "MyViewGroup             onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("Tag", "MyViewGroup                 按下");
                break;

            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                break;
            default:
                break;
        }
        return false;
    }
}
