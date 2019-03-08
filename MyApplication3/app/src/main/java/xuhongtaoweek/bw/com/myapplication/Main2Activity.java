package xuhongtaoweek.bw.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.image);
        //横向
        ObjectAnimator txanimator=ObjectAnimator.ofFloat(
                imageView,
                "translationX",
                0,
                670
        );
        //纵向
        ObjectAnimator tyanimator= ObjectAnimator.ofFloat(
                imageView,
                "translationY",
                0,
                1120
        );
        //透明
        ObjectAnimator aanimator=ObjectAnimator.ofFloat(imageView,"alpha",1.0f,0.0f);
            //旋转
        ObjectAnimator animator=ObjectAnimator.ofFloat(imageView,"rotationY",0,360);

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(tyanimator).with(txanimator).with(aanimator).with(animator);
        animatorSet.setDuration(3000);
        animatorSet.start();

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });
    }
}
