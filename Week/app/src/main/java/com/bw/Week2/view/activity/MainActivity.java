package com.bw.Week2.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.Week2.R;
import com.bw.Week2.view.base.BaseActivity;
import com.bw.Week2.view.fragement.FragementOne;
import com.bw.Week2.view.fragement.FragementThree;
import com.bw.Week2.view.fragement.FragementTwo;

public class MainActivity extends BaseActivity {


    private RadioGroup rg;
    private FragementOne fragementOne = null;
    private FragementTwo fragementTwo = null;
    private FragementThree fragementThree = null;


    @Override
    protected int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        rg = findViewById(R.id.rg);

    }

    @Override
    protected void initData() {
        rg.check(R.id.shouye);
        //管理者
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, fragementOne = new FragementOne()).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                hideFragment();
                switch (checkedId) {
                    case R.id.shouye:
                        if (fragementOne == null) {
                            fragementOne = new FragementOne();
                            transaction.add(R.id.frame, fragementOne);
                        } else {
                            transaction.show(fragementOne);
                        }
                        break;
                    case R.id.quanzi:
                        if (fragementTwo == null) {
                            fragementTwo = new FragementTwo();
                            transaction.add(R.id.frame, fragementTwo);
                        } else {
                            transaction.show(fragementTwo);
                        }
                        break;
                    case R.id.wode:
                        if (fragementThree == null) {
                            fragementThree = new FragementThree();
                            transaction.add(R.id.frame, fragementThree);
                        } else {
                            transaction.show(fragementThree);
                        }
                        break;
                }
                transaction.commit();

            }

        });


    }

    public void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragementOne != null && fragementOne.isAdded()) {
            transaction.hide(fragementOne);
        }
        if (fragementTwo != null && fragementTwo.isAdded()) {
            transaction.hide(fragementTwo);
        }
        if (fragementThree != null && fragementThree.isAdded()) {
            transaction.hide(fragementThree);
        }
        transaction.commit();

    }
}
