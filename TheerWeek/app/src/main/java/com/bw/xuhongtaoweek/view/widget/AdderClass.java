package com.bw.xuhongtaoweek.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.xuhongtaoweek.R;

/**
 * @author xuhongtao
 * @fileName AdderClass
 * @package com.bw.xuhongtaoweek.view.widget
 * @date 2019/3/7/007 19:07
 */
public class AdderClass extends RelativeLayout implements View.OnClickListener {

    private Button add, del;
    private EditText num;
    int count=0;

    public AdderClass(Context context) {
        super(context);
    }

    public AdderClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AdderClass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.adderclass, null, false);
        add = view.findViewById(R.id.add);
        del = view.findViewById(R.id.del);
        num = view.findViewById(R.id.num);
        addView(view);
        add.setOnClickListener(this);
        del.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                count++;
                num.setText(count+"");
                break;
            case R.id.del:
                if(count>0){
                    count--;
                    num.setText(count+"");
                }else{
                    Toast.makeText(getContext(), "你不能再减了", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
