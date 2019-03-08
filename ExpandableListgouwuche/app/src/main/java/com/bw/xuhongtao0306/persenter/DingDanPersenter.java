package com.bw.xuhongtao0306.persenter;

import com.bw.xuhongtao0306.model.DingDanModel;
import com.bw.xuhongtao0306.model.bean.Data;
import com.bw.xuhongtao0306.view.DingDanView;

import org.json.JSONArray;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName DingDanPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/3/5/005 8:53
 */
public class DingDanPersenter<T> {
    private Reference<T> reference;
    private final DingDanModel dingDanModel;
    private final DingDanView dingDanView;

    public DingDanPersenter(DingDanView view) {
        dingDanModel = new DingDanModel();
        dingDanView = view;
    }

    public void acttchData(T t) {
        reference=new WeakReference<>(t);
    }

    public void dingdanPersenter() {
        dingDanModel.dingdanModel();
        dingDanModel.setOnDingDanModel(new DingDanModel.OnDingDanModel() {
            @Override
            public void getData(List<Data> data) {
                dingDanView.getData(data);

            }
        });
    }

    public void datachData() {
        if(reference!=null){
            reference.clear();
            reference=null;
        }
    }
}
