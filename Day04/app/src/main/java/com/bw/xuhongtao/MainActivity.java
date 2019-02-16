package com.bw.xuhongtao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.xuhongtao.persenter.LoginPersenter;
import com.bw.xuhongtao.utils.Utils;
import com.bw.xuhongtao.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,LoginView {

    private Button login, reg;
    private EditText phone_Main, pwd_Main;
    private LoginPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        reg = findViewById(R.id.reg);
        phone_Main = findViewById(R.id.phone);
        pwd_Main = findViewById(R.id.pass);
        //实例化
        persenter = new LoginPersenter(this);
        //点击事件
        login.setOnClickListener(this);
        reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String phone = phone_Main.getText().toString();
                String pwd = pwd_Main.getText().toString();
                boolean b = Utils.isMobileNO(phone);
                if(!b){
                    Toast.makeText(this, "手机号有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pwd.length()<6){
                    Toast.makeText(this, "密码长度必须大于6位", Toast.LENGTH_SHORT).show();
                    return;
                }
                persenter.attachView(this);
                persenter.loginPersenter(phone,pwd);
                break;
            case R.id.reg:
                startActivity(new Intent(MainActivity.this,RegActivity.class));
                break;
        }
    }

    @Override
    public void logonView(String message, String status) {
        if(status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,ShowActivity.class));
            finish();
        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.detachView();
    }
}
