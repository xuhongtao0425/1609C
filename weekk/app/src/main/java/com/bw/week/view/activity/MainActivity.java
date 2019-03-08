package com.bw.week.view.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.week.R;
import com.bw.week.utils.DemoIntentService;
import com.bw.week.utils.DemoPushService;
import com.bw.week.view.fragement.FragementFour;
import com.bw.week.view.fragement.FragementOne;
import com.bw.week.view.fragement.FragementThree;
import com.bw.week.view.fragement.FragementTwo;
import com.igexin.sdk.PushManager;
import com.umeng.socialize.UMShareAPI;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);

        rg = findViewById(R.id.rg);
        rg.check(R.id.wode);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        final FragementOne fragementOne = new FragementOne();
        final FragementTwo fragementTwo = new FragementTwo();
        final FragementThree fragementThree = new FragementThree();
        final FragementFour fragementFour = new FragementFour();

        transaction.add(R.id.frame, fragementOne);
        transaction.add(R.id.frame, fragementTwo);
        transaction.add(R.id.frame, fragementThree);
        transaction.add(R.id.frame, fragementFour);
        transaction.show(fragementTwo).hide(fragementOne).hide(fragementThree).hide(fragementFour);

        transaction.commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.shouye:
                        transaction.show(fragementOne).hide(fragementTwo).hide(fragementThree).hide(fragementFour);
                        break;
                    case R.id.wode:
                        transaction.show(fragementTwo).hide(fragementOne).hide(fragementThree).hide(fragementFour);
                        break;
                    case R.id.dingdan:
                        transaction.show(fragementThree).hide(fragementOne).hide(fragementTwo).hide(fragementFour);
                        break;
                    case R.id.fenlei:
                        transaction.show(fragementFour).hide(fragementOne).hide(fragementTwo).hide(fragementThree);
                        break;
                }
                transaction.commit();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(MainActivity.this).onActivityResult(requestCode, resultCode, data);
    }
}
