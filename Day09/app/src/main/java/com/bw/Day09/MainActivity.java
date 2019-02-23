package com.bw.Day09;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDonghua text;
    private Button py, sf, xz, tm, va, oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        py = findViewById(R.id.py);
        sf = findViewById(R.id.sf);
        xz = findViewById(R.id.xz);
        tm = findViewById(R.id.tm);
        va = findViewById(R.id.va);
        oa = findViewById(R.id.oa);


        py.setOnClickListener(this);
        sf.setOnClickListener(this);
        xz.setOnClickListener(this);
        tm.setOnClickListener(this);
        va.setOnClickListener(this);
        oa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.py:
                DisplayMetrics dm = getResources().getDisplayMetrics();
                int widthPixels = dm.widthPixels;

                ObjectAnimator.ofFloat(text,"translationX",0,widthPixels)
                        .setDuration(500)
                        .start();

                break;
            case R.id.sf:
                final ObjectAnimator animator=ObjectAnimator.ofFloat(text,"xht",1.0f,0.0f);
                animator .setDuration(500);
                animator .start();
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value  = (float) animation.getAnimatedValue();
                        text.setScaleX(value);
                        text.setScaleY(value);
                    }
                });

                break;
            case R.id.xz:
                ObjectAnimator.ofFloat(text,"rotationX",0.0f,360.0f).setDuration(500).start();


                break;
            case R.id.tm:
                ObjectAnimator.ofFloat(text,"Alpha",1.0f,0.0f).setDuration(500).start();
                break;
            case R.id.va:
                break;
            case R.id.oa:
                break;
        }
    }
}
