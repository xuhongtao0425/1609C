package com.bw.Week2.view.fragement;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bw.Week2.R;
import com.bw.Week2.view.activity.Main2Activity;
import com.bw.Week2.view.base.BaseFragement;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.Week2.view.fragement
 * @date 2019/2/23/023 10:18
 */
public class FragementThree extends BaseFragement implements View.OnClickListener {

    private Button login;
    private TextView phone, pass;

    @Override
    protected int layoutResID() {
        return R.layout.fragementthree;
    }

    @Override
    protected void initView(View view) {
        login = view.findViewById(R.id.login);
        phone = view.findViewById(R.id.phone);
        pass = view.findViewById(R.id.pass);
        login.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), Main2Activity.class));
    }


}
