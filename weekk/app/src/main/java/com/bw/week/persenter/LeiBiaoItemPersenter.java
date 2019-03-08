package com.bw.week.persenter;

import com.bw.week.model.LeiBiaoItemModel;
import com.bw.week.model.bean.LeiBiaoTwoBean;
import com.bw.week.view.LeiBiaoItemView;
import com.bw.week.view.fragement.FragementFour;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName LeiBiaoItemPersenter
 * @package com.bw.week.persenter
 * @date 2019/3/2/002 9:55
 */
public class LeiBiaoItemPersenter<T> {
    private Reference<T> reference;
    private final LeiBiaoItemModel leiBiaoItemModel;
    private final LeiBiaoItemView leiBiaoItemView;

    public LeiBiaoItemPersenter(LeiBiaoItemView view) {
        leiBiaoItemModel = new LeiBiaoItemModel();
        leiBiaoItemView = view;
    }

    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }

    public void itemPersenter(String id) {
        leiBiaoItemModel.itemModel(id);

        leiBiaoItemModel.setOnLeiBiaoItemModelListener(new LeiBiaoItemModel.OnLeiBiaoItemModelListener() {
            @Override
            public void getData(List<LeiBiaoTwoBean.ResultEntity> result) {
                leiBiaoItemView.getItemData(result);
            }
        });
    }

    public void datachData() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }
    }
}
