package com.guoan.myviewtouch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * USER: 张军伟
 * DATA: 2018/1/9 0009
 * TIME: 上午 10:34
 */

@SuppressLint("AppCompatCustomView")
public class TestButton extends Button {

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("aaaaaaaaaa", "dispatchTouchEvent-- action=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("aaaaaaaaaa", "onTouchEvent-- action="+event.getAction());
        return super.onTouchEvent(event);
    }
}
