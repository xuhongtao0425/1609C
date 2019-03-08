package com.bw.xuhongtaoweek.persenter;

import com.bw.xuhongtaoweek.model.ShoppingCarModel;
import com.bw.xuhongtaoweek.model.bean.ShoppingBean;
import com.bw.xuhongtaoweek.view.ShoppingCarView;
import com.bw.xuhongtaoweek.view.fragement.ShoppingCarFragement;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShoppingCarPersenter
 * @package com.bw.xuhongtaoweek.persenter
 * @date 2019/3/7/007 18:17
 */
public class ShoppingCarPersenter<T> {
    private Reference<T> reference;
    private final ShoppingCarModel shoppingCarModel;
    private final ShoppingCarView shoppingCarView;

    public ShoppingCarPersenter(ShoppingCarView view) {
        shoppingCarModel = new ShoppingCarModel();
        shoppingCarView = view;
    }

    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }

    public void shoppingCarPersenter() {
        shoppingCarModel.shoppingCarModel();
        shoppingCarModel.setShoppingCarModelListener(new ShoppingCarModel.OnShoppingCarModelListener() {
            @Override
            public void getShoppingCarModelData(List<ShoppingBean.DataEntity> data) {
                shoppingCarView.getShoppingCarModelData(data);
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
