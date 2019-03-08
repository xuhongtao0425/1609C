package com.bw.xuhongtao.view.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.view.widget.MyView;

public class TouActivity extends AppCompatActivity {

    private MyView mv;
    private TextView user, pwd;
    private ImageView touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tou);
        mv = findViewById(R.id.mv);

        user = mv.findViewById(R.id.name);
        pwd = mv.findViewById(R.id.pwd);
        touxiang = mv.findViewById(R.id.touxiang);
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551158039424&di=0f0cff0e9d7fec174556a1a48b449363&imgtype=0&src=http%3A%2F%2Fimg18.3lian.com%2Fd%2Ffile%2F201709%2F21%2Fa05161a4469dc5ef8be88ee217d53d92.jpg")
                .apply(requestOptions)
                .into(touxiang);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pass = intent.getStringExtra("pwd");
        user.setText("用户名:" + name);
        pwd.setText("手机号:" + pass);
//https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551158039424&di=0f0cff0e9d7fec174556a1a48b449363&imgtype=0&src=http%3A%2F%2Fimg18.3lian.com%2Fd%2Ffile%2F201709%2F21%2Fa05161a4469dc5ef8be88ee217d53d92.jpg
        mv.setOnTouXiangListener(new MyView.OnTouXiangListener() {
            @Override
            public void getData() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(touxiang, "rotation", 360.0f)
                        .setDuration(3000);
                animator.start();

            }
        });

    }
}
