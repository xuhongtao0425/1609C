package com.bw.xuhongtao;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bw.xuhongtao.adapter.MyAdapter;

import java.util.ArrayList;

import xht.bw.com.myxlistview.XListView;

public class MainActivity extends AppCompatActivity {

    private GridView xListView;
    private Handler handler = new Handler();
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView = findViewById(R.id.xlistview);
        scrollView = findViewById(R.id.scrollView);


        scrollView.setFocusable(true);
        scrollView.setFocusableInTouchMode(true);
        scrollView.requestFocus();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 900; i++) {
            list.add("小苹果" + i);
        }

        xListView.setAdapter(new MyAdapter(this, list));


    }
}
