package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.ShowActivity;
import com.bw.xuhongtao.model.Bean;
import com.bw.xuhongtao.model.ShowModel;
import com.bw.xuhongtao.view.ShowView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShowPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/15/015 20:04
 */
public class ShowPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final ShowModel showModel;
    private final ShowView showView;

    //构造器
    public ShowPersenter(ShowView view) {

        showModel = new ShowModel();
        showView = view;
    }

    //管理外部类
    public void attachview(T view) {
        myReference = new WeakReference<T>(view);
    }

    //v关联p
    public void showPersenter() {
        showModel.showModel();
        showModel.setOnShowListener(new ShowModel.OnShowListener() {
            @Override
            public void showData(List<Bean.DataEntity> data) {
                showView.showView(data);
            }
        });
    }

    //当v消失就不在管理
    public void detachView() {
        if (myReference != null) {
            myReference.clear();
            myReference = null;
        }
    }
}
