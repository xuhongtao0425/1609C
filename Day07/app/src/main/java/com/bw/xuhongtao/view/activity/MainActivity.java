package com.bw.xuhongtao.view.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.ListView;
import android.widget.Toast;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.lianxi.MyView;
import com.bw.xuhongtao.persenter.MyPersenter;
import com.bw.xuhongtao.view.GoodsView;
import com.bw.xuhongtao.view.adapter.MyAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity implements GoodsView {

    private MyView myView;
    private XRecyclerView listView;
private String path="裤子";
    private MyPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取自定义view 的对象
        myView = findViewById(R.id.myview);
        //获取控件
        listView = findViewById(R.id.listview);

        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        listView.setLayoutManager(layoutManager);
        //分割线


        //实例化
        persenter = new MyPersenter(this);
        //管理
        persenter.attachPersenter(this);
        //关联
        persenter.persenterData(path);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.datachpersenter();
    }

    @Override
    public void myView(final JSONArray result) {
        //调用监听
        myView.setOnMyViewListener(new MyView.OnMyViewListener() {
            @Override
            public void gengduoData() {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
//                Toast.makeText(MainActivity.this, "暂无数据", Toast.LENGTH_SHORT).show();
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void chazhaoData(String name) {
                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "请输入数据", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(result.length()>0){
                    for (int i = 0; i < result.length(); i++) {
                        try {
                            result.remove(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                persenter.persenterData(name);
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

            }
        });

        listView.setAdapter(new MyAdapter(this,result));

    }
}
