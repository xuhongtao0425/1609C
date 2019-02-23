package com.bw.xuhongtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import com.bw.xuhongtao.persneter.GoodsPersenter;
import com.bw.xuhongtao.view.GoodsView;
import com.bw.xuhongtao.view.adapter.MyXrlvAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GoodsView {

    private XRecyclerView xrlv;
    private GoodsPersenter persenter;
    private int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xrlv = findViewById(R.id.xrlv);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        xrlv.setLayoutManager(manager);
        //实例化
        persenter = new GoodsPersenter(this);
        //内部类管理外部类
        persenter.attachView(this);
        //关联
        persenter.goodsPersenter(page);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.datachView();
    }

    @Override
    public void goodsViewData(JSONArray list, String message, String status) {
        if(status.equals("0000")){
            MyXrlvAdapter adapter = new MyXrlvAdapter(MainActivity.this);
            xrlv.setAdapter(adapter);
            if(page>1){
                adapter.addList(list);
            }else{
                adapter.updateList(list);
            }
        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }
}
