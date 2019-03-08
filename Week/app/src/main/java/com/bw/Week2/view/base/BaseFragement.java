package com.bw.Week2.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author xuhongtao
 * @fileName BaseFragement
 * @package com.bw.Week2.view.base
 * @date 2019/2/23/023 9:50
 */
public abstract class BaseFragement extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutResID(), container, false);
        initView(view);
        initData();
        return view;
    }

    protected abstract int layoutResID();

    protected abstract void initView(View view);

    protected abstract void initData();
}
