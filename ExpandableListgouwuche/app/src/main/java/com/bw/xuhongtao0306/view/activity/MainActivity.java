package com.bw.xuhongtao0306.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bw.xuhongtao0306.R;
import com.bw.xuhongtao0306.model.bean.Data;
import com.bw.xuhongtao0306.model.bean.Datas;
import com.bw.xuhongtao0306.persenter.DingDanPersenter;
import com.bw.xuhongtao0306.view.DingDanView;
import com.bw.xuhongtao0306.view.adapter.MyExpandableListViewAdapter;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DingDanView {
    private DingDanPersenter persenter;
    private ExpandableListView elv;
    private CheckBox checkBox;
    private TextView sums;
    private MyExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elv = findViewById(R.id.elv);
        checkBox = findViewById(R.id.checked);
        sums = findViewById(R.id.sums);
        //去掉箭头
        elv.setGroupIndicator(null);


        persenter = new DingDanPersenter(this);
        //管理
        persenter.acttchData(this);
        //关联
        persenter.dingdanPersenter();


    }


    @Override
    public void getData(final List<Data> data) {
        //全选按钮控制条目选中
        ischecked(data);
        //设置设配器
        adapter = new MyExpandableListViewAdapter(this, data);
        elv.setAdapter(adapter);
        //一级选中控制全选和二级的复选框
        adapter.setOnoneviewListener(new MyExpandableListViewAdapter.OnoneviewListener() {
            @Override
            public void getoneviewData(boolean frag, int groudid) {
                //定义一个变量
                int is = 0;
                //获取当前的一级条目
                Data data1 = data.get(groudid);
                // 判断当前的状态
                if (!frag) {
                    is++;
                    //把这个条目的子条目的复选框全部设置未选中
                    List<Datas> spus = data1.getSpus();
                    for (int j = 0; j < spus.size(); j++) {
                        Datas datas = spus.get(j);
                        datas.setItemChecked(false);
                    }
                } else {
                    //把这个条目的子条目的复选框全部设置选中
                    List<Datas> spus = data1.getSpus();
                    for (int j = 0; j < spus.size(); j++) {
                        Datas datas = spus.get(j);
                        datas.setItemChecked(true);
                    }
                }
                //判断变量
                if (is == 0) {
                    //当前条目的复选框设置状态
                    data.get(groudid).setChecked(true);
                    //刷新适配器
                    notifyDataSetChanged();
                    //遍历判断所有的一级条目的复选框状态
                    int n = 0;
                    for (int i = 0; i < data.size(); i++) {
                        Data data2 = data.get(i);
                        boolean checked = data2.isChecked();

                        if (!checked) {
                            n++;
                        }
                    }
                    if (n == 0) {
                        checkBox.setChecked(true);
                    } else {
                        checkBox.setChecked(false);
                    }
                } else {
                    checkBox.setChecked(false);
                    data.get(groudid).setChecked(false);
                    notifyDataSetChanged();
                }
            }
        });
        //二级选中控制一级和全选
        adapter.settowviewListener(new MyExpandableListViewAdapter.OntowviewListener() {
            @Override
            public void gettowviewData(boolean frag, int group, int child) {
                //获取当前的二级条目
                Datas datas = data.get(group).getSpus().get(child);
                if (!frag) {
                    //给当前的一级条目和二级条目的复选框赋值
                    data.get(group).setChecked(false);
                    datas.setItemChecked(false);
                } else {
                    //给当前的二级条目的复选框赋值
                    datas.setItemChecked(true);
                    //遍历所有的二级条目
                    int num = 0;
                    List<Datas> spus = data.get(group).getSpus();
                    for (int i = 0; i < spus.size(); i++) {
                        Datas datas1 = spus.get(i);
                        boolean itemChecked = datas1.isItemChecked();
                        //如果二级条目的复选框有莫选中的就num++
                        if (!itemChecked) {
                            num++;
                        }
                    }
                    //如果num等等0就是所有的都是选中的
                    if (num == 0) {
                        data.get(group).setChecked(true);
                    }
                }
                //刷新适配器
                notifyDataSetChanged();
                //遍历查询一级条目的复选框是否全部是选中的
                int che = 0;
                for (int i = 0; i < data.size(); i++) {
                    Data data1 = data.get(i);
                    boolean checked = data1.isChecked();
                    //如果一级条目的复选框有莫选中的就che++
                    if (!checked) {
                        che++;
                    }
                }
                //给全选赋值
                if (che == 0) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }

            }
        });


    }

    //全选按钮控制条目选中
    private void ischecked(final List<Data> data) {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    for (int i = 0; i < data.size(); i++) {
                        Data data1 = data.get(i);
                        data1.setChecked(true);
                        List<Datas> spus = data1.getSpus();
                        for (int j = 0; j < spus.size(); j++) {
                            Datas datas = spus.get(j);
                            datas.setItemChecked(true);
                        }
                    }
                    notifyDataSetChanged();
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        Data data1 = data.get(i);
                        data1.setChecked(false);
                        List<Datas> spus = data1.getSpus();
                        for (int j = 0; j < spus.size(); j++) {
                            Datas datas = spus.get(j);
                            datas.setItemChecked(false);
                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });
    }


    //    刷新适配器
    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }
}
