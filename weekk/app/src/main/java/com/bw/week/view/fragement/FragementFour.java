package com.bw.week.view.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.week.R;
import com.bw.week.model.bean.LeiBiaoBean;
import com.bw.week.model.bean.LeiBiaoTwoBean;
import com.bw.week.persenter.LeiBiaoItemPersenter;
import com.bw.week.persenter.LeiBiaoOnePersenter;
import com.bw.week.view.LeiBiaoItemView;
import com.bw.week.view.LeiBiaoView;
import com.bw.week.view.adapter.LeiBiaoAdapter;
import com.bw.week.view.adapter.RlvTwoAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName FragementThree
 * @package com.bw.week.view.fragement
 * @date 2019/3/2/002 8:34
 */
public class FragementFour extends Fragment implements LeiBiaoView ,LeiBiaoItemView {

    private RecyclerView leibiao1;
    private LeiBiaoOnePersenter persenter;
    private LeiBiaoItemPersenter itemPersenter;
    private View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.four, container, false);
        //控件
        leibiao1 = view.findViewById(R.id.leibiao1);
        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        leibiao1.setLayoutManager(layoutManager);
        //实例化
        persenter = new LeiBiaoOnePersenter(this);
        itemPersenter = new LeiBiaoItemPersenter(this);

        //管理
        persenter.attchData(this);
        itemPersenter.attchData(this);

        //关联
        persenter.leibiaoPersenter();
        return view;

    }


//一级
    @Override
    public void getData(List<LeiBiaoBean.ResultEntity> result) {
        if (result.size() != 0) {
            LeiBiaoAdapter adapter = new LeiBiaoAdapter(getActivity(), result);
            leibiao1.setAdapter(adapter);

        adapter.setOnLeiBiaoItemListener(new LeiBiaoAdapter.OnLeiBiaoItemListener() {
            @Override
            public void getData(String id) {
                //关联
                itemPersenter.itemPersenter(id);



            }

        });
        }
    }
    //二级
    @Override
    public void getItemData(List<LeiBiaoTwoBean.ResultEntity> result) {
        if(result.size()>0){
            RecyclerView rlv2 = view.findViewById(R.id.leibiao2);
            LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
            rlv2.setLayoutManager(layoutManager);
            rlv2.setAdapter(new RlvTwoAdapter(getActivity(),result));

        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.datachData();
        itemPersenter.datachData();

    }


}
