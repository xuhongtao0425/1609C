package com.bw.xuhongtao.lianxi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName MyView
 * @package com.bw.xuhongtao.lianxi
 * @date 2019/2/21/021 14:08
 */
public class MyView extends LinearLayout {

    private TextView gengduo;
    private EditText shousuo;
    private TextView chazhao;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }


    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.soushuokuang, null);
        addView(view);
        //获取本布局的控件
        gengduo = findViewById(R.id.gengduo);
        shousuo = findViewById(R.id.shousuo);
        chazhao = findViewById(R.id.chazhao);
        //展示更多的点击
        gengduo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyViewListener.gengduoData();
            }
        });
        //搜索的点击事件
        chazhao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = shousuo.getText().toString();
                onMyViewListener.chazhaoData(name);
            }
        });

    }
    //定义接口
    public interface OnMyViewListener{
        void gengduoData();
        void chazhaoData(String name );

    }
    //声明
    private OnMyViewListener onMyViewListener;
    //监听方法


    public void setOnMyViewListener(OnMyViewListener onMyViewListener) {
        this.onMyViewListener = onMyViewListener;
    }
}
