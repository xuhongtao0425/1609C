package com.bw.week.view;

import com.bw.week.model.bean.PagerBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName PagerView
 * @package com.bw.week.view
 * @date 2019/2/28/028 19:10
 */
public interface PagerView {
    void  getData(List<PagerBean.ResultEntity> result);
}
