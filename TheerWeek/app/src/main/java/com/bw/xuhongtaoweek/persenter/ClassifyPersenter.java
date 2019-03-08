package com.bw.xuhongtaoweek.persenter;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.ClassifyModel;
import com.bw.xuhongtaoweek.model.bean.GoodName;
import com.bw.xuhongtaoweek.view.ClassifyView;
import com.bw.xuhongtaoweek.view.fragement.ClassifyFragement;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ClassifyPersenter
 * @package com.bw.xuhongtaoweek.persenter
 * @date 2019/3/7/007 13:36
 */
public class ClassifyPersenter<T> {
    //声明
    private Reference<T> reference;

    private final ClassifyModel classifyModel;
    private final ClassifyView classifyView;

    public ClassifyPersenter(ClassifyView view) {
        classifyModel = new ClassifyModel();
        classifyView = view;
    }

    //管理
    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }

    //关联
    public void classifyPersenter() {
        classifyModel.classifyModel();
        classifyModel.setOnClassifyModelListener(new ClassifyModel.OnClassifyModelListener() {
            @Override
            public void getClassifyModelData(List<GoodName.DataEntity> data) {
                classifyView.getClassifyViewlData(data);
            }
        });
    }

    //解除关联防止泄露
    public void datachData() {
        if (reference.get() != null) {
            reference.clear();
            reference = null;
        }
    }
}
