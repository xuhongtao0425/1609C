package com.bw.Week2.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.Week2.R;
import com.bw.Week2.persenter.LoginPersenter;
import com.bw.Week2.view.LoginView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener ,LoginView {

    private EditText phone;
    private EditText pass;
    private Button login, reg;
    private LoginPersenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        phone = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        login = findViewById(R.id.login);
        reg = findViewById(R.id.reg);

        login.setOnClickListener(this);
        reg.setOnClickListener(this);

        persenter = new LoginPersenter(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String name = phone.getText().toString();
                String pwd = pass.getText().toString();
                if(name.equals("")){
                    Toast.makeText(this, "售价好不对", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pwd.length()<6){
                    Toast.makeText(this, "密码不对", Toast.LENGTH_SHORT).show();
                    return;
                }
                persenter.loginPersenter(name,pwd);

                break;
            case R.id.reg:
                startActivity(new Intent(this, RegActivity.class));
                finish();
                break;
        }

    }

    @Override
    public void getData(String message, String status) {
        Log.i("xxxxx",message);
        if(status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }
    }
}
