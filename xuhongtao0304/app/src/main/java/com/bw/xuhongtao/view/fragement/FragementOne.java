package com.bw.xuhongtao.view.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.persenter.LoginPersenter;
import com.bw.xuhongtao.utils.MyException;
import com.bw.xuhongtao.view.LoginView;
import com.bw.xuhongtao.view.MainActivity;
import com.bw.xuhongtao.view.RegActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.xuhongtao.view.fragement
 * @date 2019/3/4/004 8:51
 */
public class FragementOne extends Fragment implements View.OnClickListener, LoginView {

    private EditText name, pwd;
    private Button login, reg;
    private LoginPersenter persenter;
    private Button slogin, yichang;
    private TextView user;
    private ImageView ion_qq;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraementone, null, false);
        //控件
        name = view.findViewById(R.id.name);
        pwd = view.findViewById(R.id.pass);
        login = view.findViewById(R.id.login);
        reg = view.findViewById(R.id.reg);
        //监听
        login.setOnClickListener(this);
        reg.setOnClickListener(this);
        //实例化
        persenter = new LoginPersenter(this);


        //第三方
        slogin = view.findViewById(R.id.slogin);
        yichang = view.findViewById(R.id.yichang);
        user = view.findViewById(R.id.user);
        ion_qq = view.findViewById(R.id.image);
        yichang = view.findViewById(R.id.yichang);
        //监听
        slogin.setOnClickListener(this);
        yichang.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login://登录
                String phone = name.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(getActivity(), "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() < 6) {
                    Toast.makeText(getActivity(), "密码不能少于6位", Toast.LENGTH_SHORT).show();
                    return;
                }
                //管理
                persenter.atcchData(this);
                //关联
                persenter.loginPersenter(phone, pass);
                break;
            case R.id.reg://注册
//                startActivity(new Intent(getActivity(), RegActivity.class));

                break;
            case R.id.yichang://异常

                Log.i("xxx",1/0+"");
                break;
            case R.id.slogin://qq登录
                UMShareAPI umShareAPI = UMShareAPI.get(getActivity());
                //登录授权监听
                umShareAPI.getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        // 登录信息集合
                        Log.i("Tag",map+"");
                        String s = map.get("profile_image_url");
                        String names = map.get("screen_name");
                        Toast.makeText(getActivity(), "用户名"+names, Toast.LENGTH_SHORT).show();
                        // ion_qq是图片控件，只是为了验证登录成功后获取到你的QQ头像
                        user.setText(names);
                        Glide.with(getActivity()).load(s).into(ion_qq);
                    }
                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }
                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });

                break;
        }
    }

    @Override
    public void getLoginmodel(String message, String status) {
        if (status.equals("0000")) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除管理
        persenter.tadachData();
    }
}

