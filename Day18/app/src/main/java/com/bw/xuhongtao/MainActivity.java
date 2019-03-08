package com.bw.xuhongtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.xuhongtao.persenter.DingDanPersenter;
import com.bw.xuhongtao.view.DingDanView;
import com.bw.xuhongtao.view.adapter.MyRlvAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity implements DingDanView {

    private XRecyclerView rlv;
    private DingDanPersenter persenter;
    int page = 1;
    int sumss = 0;
    private CheckBox checkBox;
    private TextView sums;
    private MyRlvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rlv = findViewById(R.id.rlv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rlv.setLayoutManager(layoutManager);
        checkBox = findViewById(R.id.checked);
        sums = findViewById(R.id.sum);

        persenter = new DingDanPersenter(this);
        //管理
        persenter.acttchData(this);
        //关联
        persenter.dingdanPersenter(page);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = checkBox.isChecked();
                if (checked) {
                    adapter.noChecked(true);
                } else {
                    sums.setText(0 + "");
                    adapter.noChecked(false);
                }
            }
        });

    }

    @Override
    public void getData(JSONArray result) {
        if (result != null) {
            adapter = new MyRlvAdapter(MainActivity.this, result);
            adapter.setOnCheckListener(new MyRlvAdapter.OnCheckListener() {
                @Override
                public void onCheck(boolean frag) {
                    checkBox.setChecked(frag);
                }
            });
            rlv.setAdapter(adapter);
            //条目复选框总价
            adapter.setOnSumListener(new MyRlvAdapter.OnSumListener() {
                @Override
                public void onCheck(int sum) {
                    if (sum == 0) {
                        sumss = 0;
                    } else {
                        sumss += sum;
                    }
                    sums.setText("总价:" + sumss);
                }
            });
            //加减器总价
            adapter.setOnjiaSumListener(new MyRlvAdapter.OnjiaSumListener() {
                @Override
                public void onCheck(int sum) {
                    sums.setText("总价:" + sum);

                }
            });
            //全选总价
            adapter.setOnSumsListener(new MyRlvAdapter.OnSumsListener() {
                @Override
                public void onCheck(int sum) {
                        sums.setText(sum+"");

                }
            });

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.datachData();
    }


}
