package com.bw.xuhongtaoweek.view.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.ShoppingBean;
import com.bw.xuhongtaoweek.persenter.ClassifyPersenter;
import com.bw.xuhongtaoweek.persenter.ShoppingCarPersenter;
import com.bw.xuhongtaoweek.view.ShoppingCarView;
import com.bw.xuhongtaoweek.view.adapter.ShoppingAdapter;
import com.bw.xuhongtaoweek.view.adapter.ShoppingitemAdapter;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShoppingCarFragement      购物车
 * @package com.bw.xuhongtaoweek.view.fragement
 * @date 2019/3/7/007 12:52
 */
public class ShoppingCarFragement extends Fragment implements ShoppingCarView {

    private RecyclerView rlv;
    private ShoppingCarPersenter persenter;
    private CheckBox checkBox;
    private ShoppingAdapter shoppingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppingcarfragement, container, false);
        rlv = view.findViewById(R.id.rlv_shopping);
        checkBox = view.findViewById(R.id.checkbox_fra);
        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rlv.setLayoutManager(layoutManager);
        //实例化
        persenter = new ShoppingCarPersenter(this);
        //管理
        persenter.attchData(this);
        //关联
        persenter.shoppingCarPersenter();

        return view;
    }

    @Override
    public void getShoppingCarModelData(final List<ShoppingBean.DataEntity> data) {
        //全选控制
        ischecked(data);
        shoppingAdapter = new ShoppingAdapter(getActivity(), data);
        rlv.setAdapter(shoppingAdapter);
        //一级控制全选和二级
        shoppingAdapter.setOncheckBoxListener(new ShoppingAdapter.OncheckBoxListener() {
            @Override
            public void getcheckBoxData(boolean frag, int i) {
                ShoppingBean.DataEntity dataEntity = data.get(i);
                if (!frag) {
                    dataEntity.setIschecked(false);
                    List<ShoppingBean.DataEntity.ListEntity> list = dataEntity.getList();
                    for (int j = 0; j < list.size(); j++) {
                        ShoppingBean.DataEntity.ListEntity listEntity = list.get(j);
                        listEntity.setItchecked(false);
                    }
                } else {
                    dataEntity.setIschecked(true);
                    List<ShoppingBean.DataEntity.ListEntity> list = dataEntity.getList();
                    for (int j = 0; j < list.size(); j++) {
                        ShoppingBean.DataEntity.ListEntity listEntity = list.get(j);
                        listEntity.setItchecked(true);
                    }
                }
                mynotifyDataSetChanged();
                int is = 0;
                for (int j = 0; j < data.size(); j++) {
                    boolean ischecked = data.get(j).isIschecked();
                    if (!ischecked) {
                        is++;
                    }
                }
                if (is == 0) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);

                }
            }
        });
        //二级控制一级和全选

        shoppingAdapter.setBoxListener(new ShoppingAdapter.OnBoxListener() {
            @Override
            public void getcheckBoxData(boolean frag, int i, int num) {
                List<ShoppingBean.DataEntity.ListEntity> list = data.get(num).getList();
                ShoppingBean.DataEntity.ListEntity listEntity = list.get(i);
                if (!frag) {
                    listEntity.setItchecked(false);
                    data.get(num).setIschecked(false);
                    checkBox.setChecked(false);
                    mynotifyDataSetChanged();
                } else {
                    listEntity.setItchecked(true);
                    int n = 0;
                    for (int j = 0; j < list.size(); j++) {
                        ShoppingBean.DataEntity.ListEntity listEntity1 = list.get(j);
                        boolean itchecked = listEntity1.isItchecked();
                        if (!itchecked) {
                            n++;
                        }
                    }
                    if (n == 0) {
                        data.get(num).setIschecked(true);
                        mynotifyDataSetChanged();
                        int s = 0;
                        for (int j = 0; j < data.size(); j++) {
                            boolean ischecked = data.get(j).isIschecked();
                            if (!ischecked) {
                                s++;
                            }
                        }
                        if (s == 0) {
                            checkBox.setChecked(true);
                        } else {
                            checkBox.setChecked(false);

                        }
                    } else {
                        data.get(num).setIschecked(false);

                    }
                }

            }
        });
    }

    //全选控制
    private void ischecked(final List<ShoppingBean.DataEntity> data) {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setIschecked(true);
                        List<ShoppingBean.DataEntity.ListEntity> list = data.get(i).getList();
                        for (int j = 0; j < list.size(); j++) {
                            list.get(j).setItchecked(true);
                        }

                    }
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setIschecked(false);
                        List<ShoppingBean.DataEntity.ListEntity> list = data.get(i).getList();
                        for (int j = 0; j < list.size(); j++) {
                            list.get(j).setItchecked(false);
                        }

                    }

                }
                mynotifyDataSetChanged();
            }
        });
    }

    //刷新适配器
    public void mynotifyDataSetChanged() {
        shoppingAdapter.notifyDataSetChanged();
        ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.datachData();
    }

}
