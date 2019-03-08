package com.bw.week;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.week.fragment.Fragment01;
import com.bw.week.fragment.Fragment02;
import com.bw.week.fragment.Fragment03;
import com.bw.week.fragment.Fragment04;
import com.bw.week.fragment.Fragment05;

public class MainActivity extends AppCompatActivity {
    private Fragment01 fragment01;
    private FragmentManager manager;
    private Fragment05 fragment05;
    private Fragment04 fragment04;
    private Fragment03 fragment03;

    private Fragment02 fragment02;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup group= findViewById(R.id.group);
        group.check(R.id.radio0);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        fragment01 = new Fragment01();
        fragment02=new Fragment02();
        fragment03 =new Fragment03();
        fragment04=new Fragment04();
        fragment05=new Fragment05();
        transaction.add(R.id.fram,fragment01);
        transaction.add(R.id.fram,fragment02);
        transaction.add(R.id.fram,fragment03);
        transaction.add(R.id.fram,fragment04);
        transaction.add(R.id.fram,fragment05);
        transaction.show(fragment01).hide(fragment02).hide(fragment03).hide(fragment04).hide(fragment05);
        transaction.commit();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

                switch (checkedId){
                    case R.id.radio0:
                        transaction1.show(fragment01).hide(fragment02).hide(fragment03).hide(fragment04).hide(fragment05).commit();

                        break;
                    case R.id.radio1:

                        transaction1.show(fragment02).hide(fragment01).hide(fragment03).hide(fragment04).hide(fragment05).commit();
                        break;
                    case R.id.radio2:

                        transaction1.show(fragment03).hide(fragment01).hide(fragment02).hide(fragment04).hide(fragment05).commit();
                        break;
                    case R.id.radio3:

                        transaction1.show(fragment04).hide(fragment01).hide(fragment02).hide(fragment03).hide(fragment05).commit();

                        break;
                    case R.id.radio4:

                        transaction1.show(fragment05).hide(fragment01).hide(fragment02).hide(fragment03).hide(fragment04).commit();

                        break;

                }


            }
        });
    }

}
