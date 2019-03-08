package com.bw.xuhongtao.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.persenter.RegPersentter;
import com.bw.xuhongtao.view.RegView;

public class RegActivity extends AppCompatActivity implements View.OnClickListener ,RegView {
    private EditText user,pass;
    private Button reg;
    private RegPersentter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        //控件
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        reg = findViewById(R.id.reg);
        reg.setOnClickListener(this);
        //实例化LoginPersenter
        persenter = new RegPersentter(this);
    }

    @Override
    public void onClick(View v) {
        String phone = user.getText().toString().trim();
        String pwd = pass.getText().toString().trim();
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(pwd.length()<6){
            Toast.makeText(this, "密码长度不能小于6位", Toast.LENGTH_SHORT).show();
            return;
        }
        //管理
        persenter.attachPersenter(this);
        //关联
        persenter.regPersenter(phone,pwd);

    }

    @Override
    public void getData(String message, String status) {
        if(status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegActivity.this,MainActivity.class));
            finish();


        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.datachPersenter();
    }
}
