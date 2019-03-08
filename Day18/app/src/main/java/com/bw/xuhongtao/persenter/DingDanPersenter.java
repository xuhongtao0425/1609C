package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.DingDanModel;
import com.bw.xuhongtao.view.DingDanView;

import org.json.JSONArray;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

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

    public void dingdanPersenter(int page) {
        dingDanModel.dingdanModel(page);
        dingDanModel.setOnDingDanModel(new DingDanModel.OnDingDanModel() {
            @Override
            public void getData(JSONArray result) {
                dingDanView.getData(result);

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
