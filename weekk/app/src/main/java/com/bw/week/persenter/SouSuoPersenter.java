package com.bw.week.persenter;

import com.bw.week.model.SouSuoModel;
import com.bw.week.model.bean.SouSuoBean;
import com.bw.week.view.SouSuoView;
import com.bw.week.view.fragement.FragementOne;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName SouSuoPersenter
 * @package com.bw.week.persenter
 * @date 2019/3/1/001 20:07
 */
public class SouSuoPersenter<T> {
    private Reference<T> reference;
    private final SouSuoModel souSuoModel;
    private final SouSuoView souSuoView;

    public SouSuoPersenter(SouSuoView view) {
        souSuoModel = new SouSuoModel();
        souSuoView = view;
    }

    public void attchData(T t) {
        reference=new WeakReference<>(t);
    }

    public void suosouPersenter(int page, String name) {
        souSuoModel.sousuoModel(page,name);

        souSuoModel.setOnXrlvModelListener(new SouSuoModel.OnSouSuoModelListener() {
            @Override
            public void getData(List<SouSuoBean.ResultEntity> result) {

                souSuoView.getSouSuoData(result);

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
