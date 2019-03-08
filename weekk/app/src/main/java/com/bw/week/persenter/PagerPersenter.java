package com.bw.week.persenter;

import com.bw.week.model.PagerModel;
import com.bw.week.model.bean.PagerBean;
import com.bw.week.view.PagerView;
import com.bw.week.view.fragement.FragementOne;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName PagerPersenter
 * @package com.bw.week.persenter
 * @date 2019/2/28/028 18:16
 */
public class PagerPersenter<T> {
    private Reference<T> reference;
    private final PagerModel pagerModel;
    private final PagerView pagerView;

    public PagerPersenter(PagerView view) {
        pagerModel = new PagerModel();
        pagerView = view;
    }

    public void attchData(T t) {

        reference=new WeakReference<>(t);
    }

    public void pagerPersenter() {
        pagerModel.pagerModel();
        pagerModel.setOnPagerModelListener(new PagerModel.OnPagerModelListener() {
            @Override
            public void getData(List<PagerBean.ResultEntity> result) {
             pagerView.getData(result);
            }
        });

    }

    public void datachData() {
        if(reference.get()!=null){
            reference.clear();
            reference=null;
        }
    }


}
