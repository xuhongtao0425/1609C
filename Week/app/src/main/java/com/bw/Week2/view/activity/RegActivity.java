package com.bw.Week2.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.Week2.R;
import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.persenter.RegPersenter;
import com.bw.Week2.view.RegView;

import java.util.List;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,RegView {
    private EditText phone;
    private EditText pass;
    private Button reg;
    RegPersenter persenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        phone = findViewById(R.id.user_reg);
        pass = findViewById(R.id.pass_reg);

        reg = findViewById(R.id.reg);

        reg.setOnClickListener(this);




        persenter = new RegPersenter(this);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg:
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
                persenter.regPersenter(name,pwd);

                break;

        }

    }

    @Override
    public void getData(String message, String status) {
        if(status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Main2Activity.class));
            finish();
        }else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }
    }


}