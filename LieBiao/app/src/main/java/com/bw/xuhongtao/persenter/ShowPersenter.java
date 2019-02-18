package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.ShowModel;
import com.bw.xuhongtao.model.bean.Bean;
import com.bw.xuhongtao.view.ShowView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShowPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/16/016 8:05
 */
public class ShowPersenter<T> {
    //声明
    private Reference<T> myReference;
    private ShowModel showModel;
    private final ShowView showView;

    //构造方法
    public ShowPersenter(ShowView view) {
        showModel = new ShowModel();
        showView = view;
    }

    //管理MainActivity
    public void relyView(T view) {
        myReference = new WeakReference<>(view);
    }

    //关联model层
    public void showPersenter() {
        //调用model层与persenter层关联方法
        showModel.showModel();
        //接收参数
        showModel.setOnShowListener(new ShowModel.OnShowListener() {
            @Override
            public void getShowData(List<Bean.DataEntity> data) {
                showView.showView(data);
            }
        });
    }

    //解决关联
    public void separationView() {
        if (myReference != null) {
            myReference.clear();
            myReference = null;
        }
    }
}
