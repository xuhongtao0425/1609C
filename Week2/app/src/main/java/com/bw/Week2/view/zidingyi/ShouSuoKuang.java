package com.bw.Week2.view.zidingyi;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.Week2.R;

/**
 * @author xuhongtao
 * @fileName DaoHangLan
 * @package com.bw.Week2.view.zidingyi
 * @date 2019/2/22/022 17:00
 */
public class ShouSuoKuang extends LinearLayout {

    private EditText et;
    private TextView textView;

    public ShouSuoKuang(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        View view=LayoutInflater.from(context).inflate(R.layout.shuosoukuang,null,false);
        addView(view);
        et = findViewById(R.id.et);
        textView = findViewById(R.id.text);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(context, "内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                onshousuokuangListener.getData(name);
            }
        });

    }
    //定义接口
    public interface OnshousuokuangListener{
        void getData(String name);
    }
    private OnshousuokuangListener onshousuokuangListener;

    public void setOnshousuokuangListener(OnshousuokuangListener onshousuokuangListener) {
        this.onshousuokuangListener = onshousuokuangListener;
    }
}
