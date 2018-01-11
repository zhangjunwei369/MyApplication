package com.guoan.mytouchdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * USER: 张军伟
 * DATA: 2018/1/5 0005
 * TIME: 上午 9:21
 */

public class MyView extends View {
    Paint mPaint;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(33);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("你好世界", 10f, 150f, mPaint);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        Log.i("Tag", "MyView                 dispatchTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("Tag", "MyView                 按下");
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
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("Tag", "MyView                 onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("Tag", "MyView                 按下");
                break;

            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
