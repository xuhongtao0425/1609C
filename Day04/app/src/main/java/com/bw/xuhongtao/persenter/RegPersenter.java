package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.RegActivity;
import com.bw.xuhongtao.model.RegModel;
import com.bw.xuhongtao.view.RegView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName RegPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/15/015 18:56
 */
public class RegPersenter<T> {
    private Reference<T> myReference;
    private final RegModel regModel;
    private final RegView regView;

    public RegPersenter(RegView view) {
        regModel = new RegModel();
        regView = view;
    }

    //管理外部类
    public void attachView(T view) {
        myReference = new WeakReference<T>(view);
    }

    public void regPersenter(String phone, String pwd) {
        regModel.regModel(phone, pwd);
        regModel.setOnRegListener(new RegModel.OnRegListener() {
            @Override
            public void regData(String message, String status) {
                regView.regView(message, status);
            }
        });
    }

    public void detachView() {
        if (myReference != null) {
            myReference.clear();
            myReference = null;
        }

    }
}
