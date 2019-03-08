package com.bw.xuhongtaoweek.persenter;

import com.bw.xuhongtaoweek.model.ClassifyTwoMolde;
import com.bw.xuhongtaoweek.model.bean.GoodsClssBean;
import com.bw.xuhongtaoweek.view.ClassifyTwoView;
import com.bw.xuhongtaoweek.view.adapter.MyRlvAdapter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName ClassifyTwoPersenter
 * @package com.bw.xuhongtaoweek.persenter
 * @date 2019/3/7/007 14:45
 */
public class ClassifyTwoPersenter<T> {
    private Reference<T> reference;
    private final ClassifyTwoMolde classifyTwoMolde;
    private final ClassifyTwoView classifyTwoView;

    public ClassifyTwoPersenter(ClassifyTwoView view) {
        classifyTwoMolde = new ClassifyTwoMolde();
        classifyTwoView = view;
    }
    //管理
    public void attchData(T t) {
        reference = new WeakReference<>(t);
    }


    public void classifyTwoPersenter(int cid) {
        classifyTwoMolde.classifyTwoMolde(cid);
        classifyTwoMolde.setOnClassifyTwoMoldeListener(new ClassifyTwoMolde.OnClassifyTwoMoldeListener() {
            @Override
            public void getClassifyTwoMoldeData(List<GoodsClssBean.DataEntity> data) {
                classifyTwoView.getClassifyTwoViewData(data);
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
