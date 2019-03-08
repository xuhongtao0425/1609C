package com.bw.xuhongtao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.xuhongtao.R;
import com.nex3z.flowlayout.FlowLayout;

public class MainActivity extends AppCompatActivity {

    private CheckBox tui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     FlowLayout flowLayout= findViewById(R.id.flowLayout);
        for (int i = 0; i < 100; i++) {
            TextView tv=new TextView(this);
            tv.setText("下标越界"+i);

            flowLayout.addView(tv);
        }
    }
    }

