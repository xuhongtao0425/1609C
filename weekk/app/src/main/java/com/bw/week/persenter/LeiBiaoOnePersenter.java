package com.bw.week.persenter;

import com.bw.week.model.LeiBiaoModel;
import com.bw.week.model.bean.LeiBiaoBean;
import com.bw.week.view.LeiBiaoView;
import com.bw.week.view.fragement.FragementFour;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName LeiBiaoOnePersenter
 * @package com.bw.week.persenter
 * @date 2019/3/2/002 9:01
 */
public class LeiBiaoOnePersenter<T> {
    private Reference<T> reference;
    private final LeiBiaoModel leiBiaoModel;
    private final LeiBiaoView leiBiaoView;

    //构造方法
    public LeiBiaoOnePersenter(LeiBiaoView view) {
        leiBiaoModel = new LeiBiaoModel();
        leiBiaoView = view;
    }


    //管理
    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }

    //关联
    public void leibiaoPersenter() {
        leiBiaoModel.leibiaoModel();
        leiBiaoModel.setOnLeiBiaoModelListener(new LeiBiaoModel.OnLeiBiaoModelListener() {
            @Override
            public void getData(List<LeiBiaoBean.ResultEntity> result) {
                leiBiaoView.getData(result);
            }
        });

    }

    //解除管理防止泄露
    public void datachData() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }
    }
}
