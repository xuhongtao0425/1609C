package com.bw.xuhongtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.bw.xuhongtao.model.Bean;
import com.bw.xuhongtao.persenter.ZhanshiPersenter;
import com.bw.xuhongtao.view.ZhanshiView;
import com.bw.xuhongtao.view.adapter.MyRlvAdapter;

import java.util.List;

public class ZhanshiActivity extends AppCompatActivity implements ZhanshiView {

    private RecyclerView rlv;
    private ZhanshiPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhanshi);
        rlv = findViewById(R.id.rlv);
//        实例化
        persenter = new ZhanshiPersenter(this);
        //创建布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        rlv.setLayoutManager(layoutManager);
        //p管理v
        persenter.yilaiView(this);
        //p关联v
        persenter.zhanshipersenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.jiechuView();
    }

    @Override
    public void zhanshiView(List<Bean.DataEntity> data) {

        rlv.setAdapter(new MyRlvAdapter(this,data));
    }
}
