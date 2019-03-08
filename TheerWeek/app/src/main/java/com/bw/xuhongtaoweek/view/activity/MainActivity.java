package com.bw.xuhongtaoweek.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.view.fragement.ClassifyFragement;
import com.bw.xuhongtaoweek.view.fragement.ShoppingCarFragement;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rg = findViewById(R.id.rg);
        rg.check(R.id.radio0);
        //管理者
        manager = getSupportFragmentManager();
        //事务
        FragmentTransaction transaction = manager.beginTransaction();
        final ClassifyFragement classifyFragement = new ClassifyFragement();
        final ShoppingCarFragement carFragement = new ShoppingCarFragement();
        transaction.add(R.id.frame, classifyFragement);
        transaction.add(R.id.frame, carFragement);
        transaction.show(classifyFragement).hide(carFragement).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction beginTransaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.radio0:
                        beginTransaction.show(classifyFragement).hide(carFragement).commit();

                        break;
                    case R.id.radio1:
                        beginTransaction.show(carFragement).hide(classifyFragement).commit();

                        break;
                }
            }
        });


    }
}
