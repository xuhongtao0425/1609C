package com.bw.xuhongtao.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.persenter.RegPersenter;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, pwd;
    private Button login, reg;
    private RegPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pass);
        reg = findViewById(R.id.reg);
        reg.setOnClickListener(this);
        persenter = new RegPersenter();








    }

    @Override
    public void onClick(View v) {
        String phone = name.getText().toString().trim();
        String pass = pwd.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.length() < 6) {
            Toast.makeText(this, "密码不能少于6位", Toast.LENGTH_SHORT).show();
            return;
        }
        persenter.atcchData(this);
        persenter.regPersenter(phone,pass);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.tadachData();
        finish();
    }
}
