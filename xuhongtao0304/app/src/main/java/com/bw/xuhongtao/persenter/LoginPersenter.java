package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.LoginModel;
import com.bw.xuhongtao.view.LoginView;
import com.bw.xuhongtao.view.fragement.FragementOne;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName LoginPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/3/4/004 9:19
 */
public class LoginPersenter<T> {
    //声明
    private Reference<T> reference;

    private final LoginModel loginModel;
    private final LoginView loginView;

    //构造器
    public LoginPersenter(LoginView view) {
        loginModel = new LoginModel();
        loginView = view;
    }

    //管理
    public void atcchData(T t) {
        reference = new WeakReference<>(t);
    }

    //关联
    public void loginPersenter(String phone, String pass) {
        loginModel.loginModel(phone, pass);
        loginModel.setOnLoginModelLinsation(new LoginModel.OnLoginModelLinsation() {
            @Override
            public void getLoginmodel(String message, String status) {
                loginView.getLoginmodel(message, status);
            }
        });
    }

    //解除管理防止泄露
    public void tadachData() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }
    }
}
