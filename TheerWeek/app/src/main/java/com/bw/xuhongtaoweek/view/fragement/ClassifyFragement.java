package com.bw.xuhongtaoweek.view.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.GoodName;
import com.bw.xuhongtaoweek.model.bean.GoodsClssBean;
import com.bw.xuhongtaoweek.persenter.ClassifyPersenter;
import com.bw.xuhongtaoweek.persenter.ClassifyTwoPersenter;
import com.bw.xuhongtaoweek.view.ClassifyTwoView;
import com.bw.xuhongtaoweek.view.ClassifyView;

import java.util.List;

import com.bw.xuhongtaoweek.view.adapter.MyRlvAdapter;
import com.bw.xuhongtaoweek.view.adapter.MyRlvTwoAdapter;

/**
 * @author xuhongtao
 * @fileName ClassifyFragement     分类
 * @package com.bw.xuhongtaoweek.view.fragement
 * @date 2019/3/7/007 12:45
 */
public class ClassifyFragement extends Fragment implements ClassifyView ,ClassifyTwoView {

    private RecyclerView rlv,rlv2;
    private ClassifyPersenter cPersenter;
    private MyRlvAdapter myRlvAdapter;
    private ClassifyTwoPersenter twoPersenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.classifyfragement, container, false);
            //控件
        rlv = view.findViewById(R.id.rlv);
        rlv2 = view.findViewById(R.id.rlv2);
        //实例化
        cPersenter = new ClassifyPersenter(this);
        //管理
        cPersenter.attchData(this);
        //关联
        cPersenter.classifyPersenter();

        return view;
    }

    @Override
    public void getClassifyViewlData(List<GoodName.DataEntity> data) {
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        rlv.setLayoutManager(layoutManager);
        myRlvAdapter = new MyRlvAdapter(getActivity(), data);
        rlv.setAdapter(myRlvAdapter);
        //接收条目点击事件
        getClickListener(data);
    }
    //接收条目点击事件
    private void getClickListener(final List<GoodName.DataEntity> data) {
        myRlvAdapter.setOnMyRlvAdapterListener(new MyRlvAdapter.OnMyRlvAdapterListener() {



            @Override
            public void getMyRlvAdapterData(int i) {
                //实例化
                twoPersenter = new ClassifyTwoPersenter(ClassifyFragement.this);
                //管理
                twoPersenter.attchData(this);
                //关联
                int cid = data.get(i).getCid();
                twoPersenter.classifyTwoPersenter(cid);
            }
        });
    }
    //二级数据
    @Override
    public void getClassifyTwoViewData(List<GoodsClssBean.DataEntity> data) {
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        rlv2.setLayoutManager(layoutManager);
        rlv2.setAdapter(new MyRlvTwoAdapter(getActivity(),data));

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        cPersenter.datachData();
        twoPersenter.datachData();
    }


}
