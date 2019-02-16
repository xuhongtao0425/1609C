package com.bw.xuhongtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bw.xuhongtao.model.Bean;
import com.bw.xuhongtao.persenter.ShowPersenter;
import com.bw.xuhongtao.view.ShowView;
import com.bw.xuhongtao.view.adapter.MyAdapter;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements ShowView {

    private RecyclerView rlv;
    private ShowPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rlv = findViewById(R.id.rlv);
        //创建爱你布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        rlv.setLayoutManager(layoutManager);
        //实例化
        persenter = new ShowPersenter(this);
        persenter.attachview(this);
        persenter.showPersenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.detachView();
    }

    @Override
    public void showView(List<Bean.DataEntity> data) {
//        Log.i("dara",data.toString());
        rlv.setAdapter(new MyAdapter(ShowActivity.this,data));
    }
}
