package com.bw.week.persenter;

import com.bw.week.model.XrlvModel;
import com.bw.week.model.bean.Bean;
import com.bw.week.view.XrlvView;
import com.bw.week.view.fragement.FragementOne;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName XrlvPersenter
 * @package com.bw.week.persenter
 * @date 2019/2/28/028 20:30
 */
public class XrlvPersenter<T> {

    private final XrlvModel xrlvModel;
    private Reference<T> reference;
    private final XrlvView xrlvView;

    public XrlvPersenter(XrlvView view) {
        xrlvModel = new XrlvModel();
        xrlvView = view;

    }

    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }

    public void xrlvPersenter() {
        xrlvModel.xrlvModel();
        xrlvModel.setOnXrlvModelListener(new XrlvModel.OnXrlvModelListener() {
            @Override
            public void getData(Bean list) {
                xrlvView.getXrlvData(list);
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
