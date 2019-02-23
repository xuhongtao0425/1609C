package com.bw.Week2.view.fragement;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bw.Week2.R;
import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.persenter.ShowPersenter;
import com.bw.Week2.view.ShowView;
import com.bw.Week2.view.adapter.MyRlcAdapter;
import com.bw.Week2.view.base.BaseFragmet;
import com.bw.Week2.view.zidingyi.ShouSuoKuang;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.Week2.view.fragement
 * @date 2019/2/22/022 14:50
 */
public class FragementOne extends BaseFragmet implements ShowView {

    private int index;
    private ShouSuoKuang ssk;
    private SwipeRefreshLayout refreshLayout;
    private XRecyclerView rlv;
    private ShowPersenter persenter;
    private int page = 1;
    private String path = "高跟鞋";
    private List<Bean.ResultEntity> list = null;

    @Override
    protected int layoutResID() {
        return R.layout.fragement;
    }

    @Override
    protected void initView(View view) {
        Bundle arguments = getArguments();
        index = arguments.getInt("index", 0);
        //控件
        ssk = view.findViewById(R.id.ssk);

        rlv = view.findViewById(R.id.rlv);

        //实例化
        persenter = new ShowPersenter(this);
        //自定义view回调数据
        ssk.setOnshousuokuangListener(new ShouSuoKuang.OnshousuokuangListener() {
            @Override
            public void getData(String name) {

            }
        });

    }

    @Override
    protected void initData() {
        if (index == 0) {
            //管理
            persenter.attachPersenter(FragementOne.this);
            //关联
            persenter.showPersenter(page, path);

        } else if (index == 1) {

        } else if (index == 2) {

        }

    }

    //回调数据
    @Override
    public void showView(List<Bean.ResultEntity> result) {
        if (page == 1) {
            list = new ArrayList<>();
        }
        list.addAll(result);
        MyRlcAdapter adapter = new MyRlcAdapter(getActivity(), list);
        rlv.setAdapter(adapter);
        Toast.makeText(getContext(), "999", Toast.LENGTH_SHORT).show();

    }

    //静态方法
    public static FragementOne addIntsetn(int index) {
        FragementOne fragement = new FragementOne();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragement.setArguments(bundle);
        return fragement;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.datachPersenter();
    }


}
