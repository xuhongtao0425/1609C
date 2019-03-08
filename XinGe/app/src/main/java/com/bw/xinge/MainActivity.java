package com.bw.xinge;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //开启信鸽的日志输出，线上版本不建议调用
        XGPushConfig.enableDebug(this, true);

        //注册广播
        Receiver receiver=new Receiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.qq.xgdemo.activity.UPDATE_LISTVIEW");
        registerReceiver(receiver, intentFilter);
        XGPushManager.registerPush(MainActivity.this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                Log.i("xxxxxx",o.toString());
            }

            @Override
            public void onFail(Object o, int i, String s) {

            }
        });
    }
}
