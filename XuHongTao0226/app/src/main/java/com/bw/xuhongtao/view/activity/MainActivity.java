package com.bw.xuhongtao.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.persenter.LoginPersenter;
import com.bw.xuhongtao.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,LoginView {

    private EditText user,pass;
    private Button login,reg;
    private LoginPersenter persenter;
    private CheckBox jizhumima;
    private SharedPreferences preferences;
    private String phone;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("记住密码", Context.MODE_PRIVATE);
        //控件
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        reg = findViewById(R.id.reg);
        jizhumima = findViewById(R.id.jizhumima);

        boolean b = preferences.getBoolean("jizhumima", false);
        String name = preferences.getString("user", "");
        String pas = preferences.getString("pass", "");
        if(b){
            this.user.setText(name);
            this.pass.setText(pas);
            jizhumima.setChecked(b);
        }


        //实例化LoginPersenter
        persenter = new LoginPersenter(this);
        //监听
        login.setOnClickListener(this);
        reg.setOnClickListener(this);


    }

    /*
    *  监听
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                phone = user.getText().toString().trim();
                pwd = pass.getText().toString().trim();


                SharedPreferences.Editor edit = preferences.edit();
                edit.putString("user", phone);
                edit.putString("pass", pwd);
                edit.putBoolean("jizhumima",jizhumima.isChecked());
                edit.commit();


                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
            }
            //管理
                persenter.attachPersenter(this);
                //关联
                persenter.loginPersenter(phone, pwd);
                break;
            case R.id.reg:
                startActivity(new Intent(MainActivity.this,RegActivity.class));
                break;
        }
    }
    @Override
    public void getData(String message, String status) {
        if(status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, TouActivity.class);
            intent.putExtra("name",phone);
            intent.putExtra("pwd",pwd);
            startActivity(intent);
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
