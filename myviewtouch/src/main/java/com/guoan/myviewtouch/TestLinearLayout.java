package com.guoan.myviewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * USER: 张军伟
 * DATA: 2018/1/9 0009
 * TIME: 下午 3:29
 */

public class TestLinearLayout extends LinearLayout {
    public TestLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(null, "TestLinearLayout onInterceptTouchEvent-- action=" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(null, "TestLinearLayout dispatchTouchEvent-- action=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(null, "TestLinearLayout onTouchEvent-- action=" + event.getAction());
        return super.onTouchEvent(event);
    }
}
