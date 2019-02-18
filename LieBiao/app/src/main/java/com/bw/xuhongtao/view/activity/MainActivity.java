package com.bw.xuhongtao.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.model.bean.Bean;
import com.bw.xuhongtao.persenter.ShowPersenter;
import com.bw.xuhongtao.view.ShowView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ShowView {

    private RecyclerView rlv;
    private ShowPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rlv = findViewById(R.id.rlv);
        //创建布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置管理器
        rlv.setLayoutManager(layoutManager);
        //实例化
        persenter = new ShowPersenter(this);
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

    @Override
    public void showView(List<Bean.DataEntity> data) {
        MyRlvAdapter adapter = new MyRlvAdapter(this, data);
        rlv.setAdapter(adapter);
        adapter.setListener(new MyRlvAdapter.OnItemClickListener() {
            @Override
            public void OnCilck(int i) {
                Toast.makeText(MainActivity.this, "第"+i+"个", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLongClick(int i) {
                Toast.makeText(MainActivity.this, "第"+i+"长个", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
