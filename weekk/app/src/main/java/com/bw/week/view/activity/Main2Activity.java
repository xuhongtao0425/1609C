package com.bw.week.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.bw.week.R;

public class Main2Activity extends AppCompatActivity {

    private WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        w = findViewById(R.id.w);
        w.loadUrl("file:///android_asset/infos.html");
    }
}
