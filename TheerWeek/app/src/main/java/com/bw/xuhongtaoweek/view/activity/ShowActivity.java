package com.bw.xuhongtaoweek.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.ShowBean;
import com.bw.xuhongtaoweek.persenter.ShowPersenter;
import com.bw.xuhongtaoweek.view.ShowView;
import com.bw.xuhongtaoweek.view.adapter.MyShowAdapter;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements ShowView {

    private RecyclerView rlv;
    private ShowPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rlv = findViewById(R.id.rlv_show);
        //实例化
        persenter = new ShowPersenter(this);
        // 管理
        persenter.attchData(this);
        //关联
        Intent intent = getIntent();
        int pascid = intent.getIntExtra("pascid", 0);
        persenter.showPersenter(pascid);
    }

    @Override
    public void getShowViewlData(List<ShowBean.DataEntity> data) {
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rlv.setLayoutManager(layoutManager);
        rlv.setAdapter(new MyShowAdapter(this,data));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.datachData();
    }
}
