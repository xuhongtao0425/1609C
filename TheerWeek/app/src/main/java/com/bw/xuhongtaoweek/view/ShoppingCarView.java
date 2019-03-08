package com.bw.xuhongtaoweek.view;

import com.bw.xuhongtaoweek.model.bean.ShoppingBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShoppingCarView
 * @package com.bw.xuhongtaoweek.view
 * @date 2019/3/7/007 18:29
 */
public interface ShoppingCarView {
    void getShoppingCarModelData( List<ShoppingBean.DataEntity> data);
}
