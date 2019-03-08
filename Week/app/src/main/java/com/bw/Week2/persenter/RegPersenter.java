package com.bw.Week2.persenter;

import com.bw.Week2.model.LoginModel;
import com.bw.Week2.model.RegModel;
import com.bw.Week2.view.LoginView;
import com.bw.Week2.view.RegView;
import com.bw.Week2.view.activity.RegActivity;

/**
 * @author xuhongtao
 * @fileName LoginPersenter
 * @package com.bw.Week2.persenter
 * @date 2019/2/23/023 16:08
 */
public class RegPersenter {

    private final RegModel regModel;
    private final RegView regView;

    //构造方法
    public RegPersenter(RegView view) {
        regModel = new RegModel();
        regView = view;
    }

    public void regPersenter(String name, String pwd) {

        regModel.regModel(name,pwd);
        regModel.setOnRegModelListener(new RegModel.OnRegModelListener() {
            @Override
            public void getData(String message, String status) {
                regView.getData(message,status);
            }
        });

    }
}
