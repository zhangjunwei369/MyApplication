package com.guoan.myviewtouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener{
    private LinearLayout mLayout;
    private TestButton mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (LinearLayout) this.findViewById(R.id.mylayout);
        mButton = (TestButton) this.findViewById(R.id.my_btn);

        mLayout.setOnTouchListener(this);
        mButton.setOnTouchListener(this);

        mLayout.setOnClickListener(this);
        mButton.setOnClickListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i("aaaaaaaaaa", "OnTouchListener--onTouch-- action="+event.getAction()+" --"+v);
        return false;
    }

    @Override
    public void onClick(View v) {
        Log.i("aaaaaaaaaa", "OnClickListener--onClick--"+v);
    }


}
