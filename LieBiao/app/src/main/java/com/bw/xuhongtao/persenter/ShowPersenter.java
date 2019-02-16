package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.MainActivity;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.model.ShowModel;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

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

    //构造方法
    public ShowPersenter() {
        showModel = new ShowModel();
    }

    //管理MainActivity
    public void relyView(T view) {
        myReference = new WeakReference<>(view);
    }

    //关联model层
    public void showPersenter() {
        //调用model层与persenter层关联方法
        showModel.showModel();
    }

    //解决关联
    public void separationView() {
        if (myReference != null) {
            myReference.clear();
            myReference = null;
        }
    }
}
