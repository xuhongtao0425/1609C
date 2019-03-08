package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.model.LoginModel;
import com.bw.xuhongtao.view.LoginView;
import com.bw.xuhongtao.view.activity.MainActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName LoginPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/26/026 8:55
 */
public class LoginPersenter<T> {
    //声明
    private Reference<T> reference;
    private final LoginModel loginModel;
    private final LoginView loginView;

    /*
     * 构造方法
     *
     * */
    public LoginPersenter(LoginView view) {
        loginModel = new LoginModel();
        loginView = view;

    }

    public void attachPersenter(T t) {
        reference = new WeakReference<>(t);
    }

    public void loginPersenter(String phone, String pwd) {
        //关联molde层
        loginModel.logonMolde(phone,pwd);
        //回调数据
        loginModel.setOnLoginModelListener(new LoginModel.OnLoginModelListener() {
            @Override
            public void getData(String message, String status) {
                loginView.getData(message,status);

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
