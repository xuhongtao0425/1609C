package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.ZhanshiActivity;
import com.bw.xuhongtao.model.Bean;
import com.bw.xuhongtao.model.ZhanshiModel;
import com.bw.xuhongtao.view.ZhanshiView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ZhanshiPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/17/017 15:46
 */
public class ZhanshiPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final ZhanshiModel zhanshiModel;
    private final ZhanshiView zhanshiView;
    //构造器

    public ZhanshiPersenter(ZhanshiView view) {
        zhanshiModel = new ZhanshiModel();
        zhanshiView = view;
    }

    public void yilaiView(T view) {
        myReference = new WeakReference<T>(view);
    }

    public void zhanshipersenter() {
        zhanshiModel.zhanshiModel();
        zhanshiModel.setOnZhanshiLinstn(new ZhanshiModel.OnZhanshiLinstn() {
            @Override
            public void zhanshiData(List<Bean.DataEntity> data) {
                zhanshiView.zhanshiView(data);
            }
        });
    }

    public void jiechuView() {
        if (myReference.get() != null) {
            myReference.clear();
            myReference = null;
        }
    }
}
