package com.bw.xuhongtao.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.utils.GeTui;
import com.bw.xuhongtao.utils.GeTuiDe;
import com.bw.xuhongtao.view.fragement.FragementOne;
import com.bw.xuhongtao.view.fragement.FragementTwo;
import com.igexin.sdk.PushManager;
import com.umeng.socialize.UMShareAPI;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // com.getui.demo.GeTui 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(), GeTui.class);
      // com.getui.demo. GeTuiDe 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), GeTuiDe.class);

        rg = findViewById(R.id.rg);
        rg.check(R.id.radio);
        final FragementOne fragementOne = new FragementOne();
        final FragementTwo fragementTwo = new FragementTwo();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, fragementOne);
        transaction.add(R.id.frame, fragementTwo);
        transaction.show(fragementOne).hide(fragementTwo);
        transaction.commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.radio:
                        transaction1.show(fragementOne).hide(fragementTwo);
                        break;
                    case R.id.radio1:
                        transaction1.show(fragementTwo).hide(fragementOne);
                        break;
                }
                transaction1.commit();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(MainActivity.this).onActivityResult(requestCode, resultCode, data);
    }
}
