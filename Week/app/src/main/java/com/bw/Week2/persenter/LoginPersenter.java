package com.bw.Week2.persenter;

import com.bw.Week2.model.LoginModel;
import com.bw.Week2.view.LoginView;
import com.bw.Week2.view.activity.Main2Activity;

/**
 * @author xuhongtao
 * @fileName LoginPersenter
 * @package com.bw.Week2.persenter
 * @date 2019/2/23/023 16:08
 */
public class LoginPersenter {

    private final LoginModel loginModel;
    private final LoginView loginView;

    //构造方法
    public LoginPersenter(LoginView view) {
        loginModel = new LoginModel();
        loginView = view;
    }

    public void loginPersenter(String name, String pwd) {

        loginModel.loginModel(name,pwd);
        loginModel.setOnLoginModelListener(new LoginModel.OnLoginModelListener() {
            @Override
            public void getData(String message, String status) {
                loginView.getData(message,status);
            }
        });

    }
}
