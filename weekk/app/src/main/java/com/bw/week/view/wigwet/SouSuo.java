package com.bw.week.view.wigwet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.week.R;

/**
 * @author xuhongtao
 * @fileName SouSuo
 * @package com.bw.week.view.wigwet
 * @date 2019/2/28/028 17:55
 */
public class SouSuo extends LinearLayout {
    private TextView saomiao,sousuo;
    private EditText name;

    public SouSuo(Context context) {
        super(context);
    }

    public SouSuo(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SouSuo(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null, false);
        addView(view);
        saomiao= view.findViewById(R.id.saomiao);
        sousuo= view.findViewById(R.id.sousuo);
        name = view.findViewById(R.id.name);
        //扫描
        saomiao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onSaoMiaoListener!=null){

                    onSaoMiaoListener.getData();
                }

            }
        });
        //搜索
        sousuo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = SouSuo.this.name.getText().toString().trim();
                if(onSousuoListener!=null){
                    onSousuoListener.getData(name);
                }
            }
        });
    }
    //扫描
    public interface OnSaoMiaoListener{
      void   getData();
    }
    private OnSaoMiaoListener onSaoMiaoListener;

    public void setOnSaoMiaoListener(OnSaoMiaoListener onSaoMiaoListener) {
        this.onSaoMiaoListener = onSaoMiaoListener;
    }
    //搜索
    public interface OnSousuoListener{
        void   getData(String name);
    }
    private OnSousuoListener onSousuoListener;

    public void setOnSousuoListener(OnSousuoListener onSousuoListener) {
        this.onSousuoListener = onSousuoListener;
    }
}
