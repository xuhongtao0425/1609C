package com.bw.Week2.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author xuhongtao
 * @fileName BaseActivity
 * @package com.bw.Week2.view.base
 * @date 2019/2/23/023 9:49
 */
public abstract  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResID());
        initView();
        initData();

    }

    protected abstract int layoutResID();

    protected abstract void initView();

    protected abstract void initData();

}
