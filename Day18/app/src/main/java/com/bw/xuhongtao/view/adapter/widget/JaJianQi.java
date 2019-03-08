package com.bw.xuhongtao.view.adapter.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName JaJianQi
 * @package com.bw.xuhongtao.view.adapter.widget
 * @date 2019/3/5/005 11:24
 */
public class JaJianQi extends RelativeLayout implements View.OnClickListener {

    private Button jia, jian;
    private EditText num;
    private int i = 1;


    public JaJianQi(Context context) {
        super(context);
    }

    public JaJianQi(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }


    public JaJianQi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(final Context context) {
         LayoutInflater.from(context).inflate(R.layout.jiajianqi,this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        num = findViewById(R.id.num);
        //不可编辑
        num.setFocusable(false);

//加加
        jia.setOnClickListener(this);
        //减减
        jian.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jia:
                i++;
                num.setText(i+"");
                if (onNumListener != null) {
                    onNumListener.getNumData(i);
                }
                break;
            case R.id.jian:
                if (i > 1) {
                    i--;
                    num.setText(i+"");
                    if (onNumListener != null) {
                        onNumListener.getNumData(i);
                    }

                } else {
                    return;
                }
                break;
        }
    }

    //获取数据的方法
    public int num(){
        String s = num.getText().toString();


        return Integer.parseInt(s);
    }





    public interface onNumListener {
        void getNumData(int num);
    }

    private onNumListener onNumListener;

    public void setOnNumListener(onNumListener onNumListener) {
        this.onNumListener = onNumListener;
    }


}
