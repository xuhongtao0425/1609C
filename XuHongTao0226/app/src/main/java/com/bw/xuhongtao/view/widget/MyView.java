package com.bw.xuhongtao.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName MyView
 * @package com.bw.xuhongtao.view.widget
 * @date 2019/2/26/026 10:01
 */
public class MyView extends RelativeLayout {

    private TextView naem,pwd;
    private ImageView touxiang;

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
        View view = LayoutInflater.from(context).inflate(R.layout.widget, null, false);
        addView(view);
        naem = view.findViewById(R.id.name);
        pwd = view.findViewById(R.id.pwd);
        touxiang = view.findViewById(R.id.touxiang);
        touxiang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouXiangListener.getData();
            }
        });
    }
    public interface OnTouXiangListener{
        void getData();
    }
    private OnTouXiangListener onTouXiangListener;

    public void setOnTouXiangListener(OnTouXiangListener onTouXiangListener) {
        this.onTouXiangListener = onTouXiangListener;
    }
}
