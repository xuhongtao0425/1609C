package com.bw.Week2.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.Week2.R;

import org.w3c.dom.Text;

/**
 * @author xuhongtao
 * @fileName CustomLogin
 * @package com.bw.Week2.view.widget
 * @date 2019/2/23/023 14:18
 */
public class CustomLogin extends TextView {
    public CustomLogin(Context context) {
        super(context);
    }

    public CustomLogin(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }



    public CustomLogin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initView(Context context, AttributeSet attrs) {
      if(attrs!=null){
          TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomLogin);
          String string = ta.getString(R.styleable.CustomLogin_login);
      }
    }
}
