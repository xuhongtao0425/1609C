package com.bw.Week2.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.Week2.R;
import com.bw.Week2.view.base.BaseActivity;
import com.bw.Week2.view.fragement.FragementOne;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {


    private ViewPager viewPager;
    private RadioGroup rg;


    @Override
    protected int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //控件
        viewPager = findViewById(R.id.viewpager);
        rg = findViewById(R.id.rg);

    }

    @Override
    protected void initData() {
        //第一个按钮选中
        rg.check(R.id.shouye);
//设配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                FragementOne fragementOne = FragementOne.addIntsetn(i);
                return fragementOne;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        //viewpager监听
        viewPager.addOnPageChangeListener(this);
        rg.setOnCheckedChangeListener(this);
    }

    //viewpager监听
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        rg.check(rg.getChildAt(i).getId());
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    //rg监听
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.shouye:
                viewPager.setCurrentItem(0);
                break;
            case R.id.quanzi:
                viewPager.setCurrentItem(1);
                break;
            case R.id.dingdan:
                viewPager.setCurrentItem(2);
                break;
        }

    }
}
