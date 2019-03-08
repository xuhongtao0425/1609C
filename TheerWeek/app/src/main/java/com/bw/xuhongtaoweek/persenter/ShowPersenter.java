package com.bw.xuhongtaoweek.persenter;

import com.bw.xuhongtaoweek.model.ShowModel;
import com.bw.xuhongtaoweek.model.bean.ShowBean;
import com.bw.xuhongtaoweek.view.ShowView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShowPersenter
 * @package com.bw.xuhongtaoweek.persenter
 * @date 2019/3/7/007 16:39
 */
public class ShowPersenter<T> {
    //声明
    private Reference<T> reference;
    private final ShowModel showModel;
    private final ShowView showView;

    public ShowPersenter(ShowView view) {
        showModel = new ShowModel();
        showView = view;
    }

    //管理
    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }

    public void showPersenter(int pscid) {
        showModel.showModel(pscid);
        showModel.setOnShowModelListener(new ShowModel.OnShowModelListener() {
            @Override
            public void getshowModelData(List<ShowBean.DataEntity> data) {
                showView.getShowViewlData(data);
            }
        });
    }

    //解除关联防止泄露
    public void datachData() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }
    }
}
