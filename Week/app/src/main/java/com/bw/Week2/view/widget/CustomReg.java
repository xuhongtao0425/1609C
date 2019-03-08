package com.bw.Week2.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.Week2.R;

import static com.bw.Week2.R.styleable.CustomReg_Imag;

/**
 * @author xuhongtao
 * @fileName CustomReg
 * @package com.bw.Week2.view.widget
 * @date 2019/2/23/023 14:55
 */
public class CustomReg extends RelativeLayout {

    private String text;
    private int ima;

    public CustomReg(Context context) {
        super(context);
    }

    public CustomReg(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CustomReg(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomReg);

            text = ta.getString(R.styleable.CustomReg_text);
//            ima = ta.getInteger(R.styleable.CustomReg_Imag, R.drawable.loading_01);

            TextView textView = new TextView(context);
            textView.setText(text);
            ImageView imageView = new ImageView(context);
//            imageView.setImageResource(ima);

//            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
//            addView(imageView, params);

            LayoutParams param = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            param.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
            addView(textView, param);
        }
    }
}
