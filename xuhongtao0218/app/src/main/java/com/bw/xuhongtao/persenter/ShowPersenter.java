package com.bw.xuhongtao.persenter;

import com.bw.xuhongtao.model.ShowModel;
import com.bw.xuhongtao.model.bean.Datas;
import com.bw.xuhongtao.view.ShowView;
import com.bw.xuhongtao.view.activity.MainActivity;

import org.json.JSONArray;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @author xuhongtao
 * @fileName ShowPersenter
 * @package com.bw.xuhongtao.persenter
 * @date 2019/2/18/018 8:58
 */
public class ShowPersenter<T> {
    //声明
    private Reference<T> myReference;
    private final ShowModel showModel;
    private final ShowView showView;
    //构造方法


    public ShowPersenter(ShowView view) {
        showModel = new ShowModel();
        showView = view;
    }

    //防止泄漏
    public void yilaiView(T view) {
        myReference=new WeakReference<T>(view);
    }
//关联
    public void showPersenter() {
        showModel.showModel();
        showModel.setOnShowListener(new ShowModel.OnShowListener() {
            @Override
            public void getShowData(JSONArray data1) {
                showView.ShowView(data1);
            }
        });

    }

    public void fenliView() {
        if(myReference.get()!=null){
            myReference.clear();;
            myReference=null;
        }
    }
}
