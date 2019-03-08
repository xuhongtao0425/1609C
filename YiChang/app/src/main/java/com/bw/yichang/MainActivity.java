package com.bw.yichang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CrashHandlerTwo.getInstnia().init(this);
        CrashHandler.getInstance().init(this);

      String a=null;
      String s=a.toString();
        Log.i("xx",s);

    }
}
