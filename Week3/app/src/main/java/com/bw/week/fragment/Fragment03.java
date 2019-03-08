package com.bw.week.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.week.R;


/**
 * @author yaoqi
 * @fileName Fragment03
 * @package com.bw.yq.fragment
 * @date 2019/2/27 20:40
 */
public class Fragment03 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag03, container, false);
        return view;
    }
}
