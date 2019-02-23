package com.bw.xuhongtao.wan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName TopBar
 * @package com.bw.xuhongtao
 * @date 2019/2/19/019 19:06
 */

public class TopBar extends TextView {

    private String title;
    private String leftText;
    private String rightText;
    private int leftTextColor, rightTextColor, titleTextColor;
    private int leftBackground, rightBackground;

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }


    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        if (typedArray != null) {

            //文字
            title = typedArray.getString(R.styleable.TopBar_title1);

            //颜色

            titleTextColor = typedArray.getInteger(R.styleable.TopBar_titleTextColor1, -1);
            //背景

            setText(title);


            setTextColor(titleTextColor);

        }
        typedArray.recycle();
    }

}
