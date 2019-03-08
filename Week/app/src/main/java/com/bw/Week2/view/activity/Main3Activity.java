package com.bw.Week2.view.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.bw.Week2.R;

public class Main3Activity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text = findViewById(R.id.text);
        final ObjectAnimator animator = ObjectAnimator.ofFloat(text, "zyx", 0.0f, 1.0f).setDuration(1000);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int i = dm.heightPixels;
        final ObjectAnimator animator1 = ObjectAnimator.ofFloat(text, "translationY", 200.0f, (i-200)).setDuration(5000);
        animator1.start();
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                text.setAlpha(value);
                text.setScaleX(value);
                text.setScaleY(value);
            }
        });

    }
}
