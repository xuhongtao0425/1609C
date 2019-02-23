package com.bw.xuhongtao.persneter;

import com.bw.xuhongtao.MainActivity;
import com.bw.xuhongtao.model.GoodsModel;
import com.bw.xuhongtao.view.GoodsView;

import org.json.JSONArray;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName GoodsPersenter
 * @package com.bw.xuhongtao.persneter
 * @date 2019/2/19/019 9:02
 */
public class GoodsPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final GoodsModel goodsModel;
    private final GoodsView goodsView;

    public GoodsPersenter(GoodsView view) {
        goodsModel = new GoodsModel();
        goodsView = view;
    }


    public void attachView(T v) {
        myReference=new WeakReference<>(v);
    }

    public void goodsPersenter(int page) {
        goodsModel.goodsModel(page);
        goodsModel.setOnGoodsLinston(new GoodsModel.OnGoodsLinston() {
            @Override
            public void goodsData(JSONArray list, String message, String status) {
                goodsView.goodsViewData(list,message,status);
            }
        });

    }

    public void datachView() {
        if(myReference.get()!=null){
            myReference.clear();
            myReference=null;
        }
    }
}
