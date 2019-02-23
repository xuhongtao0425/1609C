package com.bw.xuhongtao.view.activity;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.lianxi.DongHua;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private DongHua donghua;
    private Button chuizhi, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        donghua = findViewById(R.id.donghua);
        chuizhi = findViewById(R.id.chuizhi);
        pw = findViewById(R.id.pw);
        chuizhi.setOnClickListener(this);
        pw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chuizhi:
                WindowManager wm = this.getWindowManager();
                int height = wm.getDefaultDisplay().getHeight();
                final ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(0, height - donghua.getHeight());
                valueAnimator1.setTarget(donghua);
                valueAnimator1.setDuration(500);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        donghua.setTranslationY((Float) animation.getAnimatedValue());
                    }
                });
                valueAnimator1.start();
                break;
            case R.id.pw:
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(3000);
                valueAnimator.setObjectValues(new PointF(0, 0));
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
                {
                    // fraction = t / duration
                    @Override
                    public PointF evaluate(float fraction, PointF startValue,
                                           PointF endValue)
                    {

                        // x方向200px/s ，则y方向0.5 * 10 * t
                        PointF point = new PointF();
                        point.x = 200 * fraction * 3;
                        point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                        return point;
                    }
                });

                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation)
                    {
                        PointF point = (PointF) animation.getAnimatedValue();
                        donghua.setX(point.x);
                        donghua.setY(point.y);

                    }
                });

                break;
        }
    }
}
