package com.bw.xuhongtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.xuhongtao.persenter.ShowPersenter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;
    private ShowPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rlv = findViewById(R.id.rlv);
        //创建布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置管理器
        rlv.setLayoutManager(layoutManager);
        //实例化
        persenter = new ShowPersenter();
        //调用persenter层管理此类的方法
        persenter.relyView(this);
        //调用persenter层与view层关联方法
        persenter.showPersenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当此类要被销毁了调用解决关联方法
        persenter.separationView();
    }
}
