package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.MainActivity;
import com.bw.xuhongtao.model.LoginModel;
import com.bw.xuhongtao.view.LoginView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author xuhongtao
 * @fileName LoginPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/15/015 16:57
 */
public class LoginPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final LoginModel loginModel;
    private final LoginView loginView;

    public LoginPersenter(LoginView view) {
        loginModel = new LoginModel();
        loginView = view;
    }

    public void attachView(T view) {
        myReference = new WeakReference<T>(view);
    }

    public void loginPersenter(String phone, String pwd) {
        loginModel.loginModel(phone, pwd);
        loginModel.setOnLoginListener(new LoginModel.OnLoginListener() {
            @Override
            public void loginData(String message, String status) {
                loginView.logonView(message, status);
            }
        });
    }
    public void detachView(){
        if(myReference!=null){
            myReference.clear();
            myReference=null;
        }
    }
}
