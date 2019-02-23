package com.bw.xuhongtao.wan;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName Ni
 * @package com.bw.xuhongtao
 * @date 2019/2/19/019 20:49
 */
public class Ni extends TextView {
    private String title;
    private String leftText;
    private String rightText;
    private int leftTextColor, rightTextColor, titleTextColor;
    private int leftBackground, rightBackground;

    public Ni(Context context) {
        super(context);
    }

    public Ni(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public Ni(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Ni);
        if (typedArray != null) {

            //文字

            rightText = typedArray.getString(R.styleable.Ni_rightText);
            //颜色
            rightTextColor = typedArray.getInteger(R.styleable.Ni_rightTextColor, -1);
            //背景
            rightBackground = typedArray.getInteger(R.styleable.Ni_rightBackground, -1);
            setText(rightText);
            setTextColor(rightTextColor);
            setBackgroundColor(rightBackground);
        }
        typedArray.recycle();
    }


}
