package com.bw.xuhongtao.view.activity;

import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.model.bean.Datas;
import com.bw.xuhongtao.persenter.ShowPersenter;
import com.bw.xuhongtao.view.ShowView;
import com.bw.xuhongtao.view.adapter.MyRlvAdapter;

import org.json.JSONArray;

import java.util.ArrayList;

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
        //设置布局管理器
        rlv.setLayoutManager(layoutManager);
        rlv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10, 10, 10, 10);
            }
        });
        //实例化
        persenter = new ShowPersenter(this);
        //调用yilaiView
        persenter.yilaiView(this);
        //关联
        persenter.showPersenter();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.fenliView();
    }

    @Override
    public void ShowView(JSONArray data1) {
        final MyRlvAdapter adapter = new MyRlvAdapter(this, data1);
        rlv.setAdapter(adapter);
        adapter.setOnClick(new MyRlvAdapter.OnClick() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void Onclick(JSONArray data1, int i) {
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                try {

                    data1.remove(i);
                   adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
