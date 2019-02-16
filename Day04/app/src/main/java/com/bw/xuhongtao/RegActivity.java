package com.bw.xuhongtao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.xuhongtao.persenter.RegPersenter;
import com.bw.xuhongtao.utils.Utils;
import com.bw.xuhongtao.view.RegView;

public class RegActivity extends AppCompatActivity implements View.OnClickListener ,RegView {
    private Button  reg;
    private EditText phone_Main, pwd_Main;
    private RegPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        reg = findViewById(R.id.reg);
        phone_Main = findViewById(R.id.phone);
        pwd_Main = findViewById(R.id.pass);
        //实例化
        persenter = new RegPersenter(this);
        persenter.attachView(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
        persenter.regPersenter(phone,pwd);

    }

    @Override
    public void regView(String message, String status) {
        if(status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegActivity.this,MainActivity.class));
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
