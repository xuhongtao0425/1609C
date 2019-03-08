package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.LoginModel;
import com.bw.xuhongtao.model.RegModel;
import com.bw.xuhongtao.view.LoginView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName RegPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/3/4/004 9:50
 */
public class RegPersenter<T> {
    private Reference<T> reference;
    private final RegModel regModel;

    public RegPersenter() {
        regModel = new RegModel();

    }

    public void atcchData(T t) {
        reference=new WeakReference<>(t);
    }

    public void regPersenter(String phone, String pass) {
      regModel.regModel(phone,pass);
    }

    public void tadachData() {
        if(reference.get()!=null){
            reference.clear();
            reference=null;
        }
    }
}
