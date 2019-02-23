package com.bw.xuhongtao.wan;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName Back
 * @package com.bw.xuhongtao
 * @date 2019/2/19/019 20:47
 */
public class Back extends TextView {
    private String title;
    private String leftText;
    private String rightText;
    private int leftTextColor, rightTextColor, titleTextColor;
    private int leftBackground, rightBackground;
    public Back(Context context) {
        super(context);
    }

    public Back(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public Back(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Back);
        if (typedArray != null) {

            //文字

            leftText = typedArray.getString(R.styleable.Back_leftText);

            //颜色
            leftTextColor = typedArray.getInteger(R.styleable.Back_leftTextColor, -1);

            //背景
            leftBackground = typedArray.getInteger(R.styleable.Back_leftBackground, -1);


            setText(leftText);

            setTextColor(leftTextColor);

            setBackgroundColor(leftBackground);

        }
        typedArray.recycle();
    }


}
