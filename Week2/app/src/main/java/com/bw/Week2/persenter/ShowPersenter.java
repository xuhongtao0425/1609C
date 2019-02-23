package com.bw.Week2.persenter;

import com.bw.Week2.model.ShowModel;
import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.view.ShowView;
import com.bw.Week2.view.fragement.FragementOne;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShowPersenter
 * @package com.bw.Week2.persenter
 * @date 2019/2/22/022 18:55
 */
public class ShowPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final ShowModel showModel;
    private final ShowView showView;
    //构造方法

    public ShowPersenter(ShowView view) {
        showModel = new ShowModel();
        showView = view;

    }

    //管里
    public void attachPersenter(T t) {
        myReference = new WeakReference<>(t);
    }

    //关联
    public void showPersenter(int page, String path) {
        //关联
        showModel.showModel(page , path);
        //回调数据
        showModel.setOnShowListener(new ShowModel.OnShowListener() {
            @Override
            public void showData(List<Bean.ResultEntity> result) {
                //传输局
                showView.showView(result);
            }
        });
    }

    //解除管理防止内存泄漏
    public void datachPersenter() {
        if (myReference.get() != null) {
            myReference.clear();
            myReference = null;
        }

    }
}
