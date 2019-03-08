package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.LoginModel;
import com.bw.xuhongtao.model.RegModel;
import com.bw.xuhongtao.view.LoginView;
import com.bw.xuhongtao.view.RegView;
import com.bw.xuhongtao.view.activity.RegActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName RegPersentter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/26/026 8:55
 */
public class RegPersentter<T> {
    //声明
    private Reference<T> reference;
    private final RegModel regModel;
    private final RegView regView;

    /*
     * 构造方法
     *
     * */
    public RegPersentter(RegView view) {
        regModel = new RegModel();
        regView = view;

    }

    public void attachPersenter(T t) {
        reference = new WeakReference<>(t);
    }

    public void regPersenter(String phone, String pwd) {
        //关联molde层
        regModel.regMolde(phone,pwd);
        //回调数据
        regModel.setOnLoginModelListener(new RegModel.OnRegModelListener() {
            @Override
            public void getData(String message, String status) {
                regView.getData(message,status);
            }
        });

    }

    /*
     *解除管理
     * 防止内存泄露
     *
     * */
    public void datachPersenter() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }
    }
}
