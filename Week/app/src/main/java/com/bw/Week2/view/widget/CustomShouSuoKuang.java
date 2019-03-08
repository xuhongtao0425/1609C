package com.bw.Week2.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.Week2.R;
import com.bw.Week2.view.adapter.MyListviewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName CustomShouSuoKuang
 * @package com.bw.Week2.view.widget
 * @date 2019/2/23/023 9:56
 */
public class CustomShouSuoKuang extends LinearLayout {

    private EditText ev;
    private TextView textView;


    public CustomShouSuoKuang(Context context) {
        super(context);
    }

    public CustomShouSuoKuang(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    public CustomShouSuoKuang(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.customshousuokuang, null, false);
        addView(view);
        ev = view.findViewById(R.id.ev);
        textView = view.findViewById(R.id.shousuo);







        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ev.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(context, "搜索不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                onCustomShouSuoKuangListener.getData(name);

            }
        });

    }

    public interface OnCustomShouSuoKuangListener {
        void getData(String name);
    }

    private OnCustomShouSuoKuangListener onCustomShouSuoKuangListener;

    public void setOnCustomShouSuoKuangListener(OnCustomShouSuoKuangListener onCustomShouSuoKuangListener) {
        this.onCustomShouSuoKuangListener = onCustomShouSuoKuangListener;
    }
}
