package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.MyModel;
import com.bw.xuhongtao.view.GoodsView;
import com.bw.xuhongtao.view.activity.MainActivity;

import org.json.JSONArray;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName MyPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/21/021 14:44
 */
public class MyPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final MyModel myModel;
    private final GoodsView goodsView;

//构造器

    public MyPersenter(GoodsView view) {
        myModel = new MyModel();
        goodsView = view;
    }

    //    管理
    public void attachPersenter(T t) {
        myReference = new WeakReference<T>(t);
    }

    //关联
    public void persenterData(String path) {
        //p层关联m
        myModel.modelData(path);
        //回调数据
        myModel.setOnMyModelListener(new MyModel.OnMyModelListener() {
            @Override
            public void myModelData(JSONArray result) {

                goodsView.myView(result);

            }
        });
    }

    //解除管理防止内存泄露
    public void datachpersenter() {
        if(myReference.get()!=null){
            myReference.clear();
            myReference=null;
        }
    }
}
