package com.bw.Week2.persenter;

import com.bw.Week2.R;
import com.bw.Week2.model.GoodsModel;
import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.view.GoodsView;
import com.bw.Week2.view.fragement.FragementOne;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName GoodsPersenter
 * @package com.bw.Week2.persenter
 * @date 2019/2/23/023 10:38
 */
public class GoodsPersenter<T> {
    //声明
    Reference<T> reference;
    private final GoodsView goodsView;
    private final GoodsModel goodsModel;

    //构造方法


    public GoodsPersenter(GoodsView view) {
        goodsModel = new GoodsModel();
        goodsView = view;
    }

    //管理
    public void attachView(T t) {
        reference = new WeakReference<>(t);
    }

    //关联
    public void goodsPersenter(int page, String name) {

        //关联
        goodsModel.goodsModel(page,name);
        //回调数据
        goodsModel.setOnGoodsModelListener(new GoodsModel.OnGoodsModelListener() {
            @Override
            public void getData(List<Bean.ResultEntity> result) {
                goodsView.getData(result);
            }
        });

    }

    //解除管理防止内存泄露
    public void datachView() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }

    }


}
