package com.bw.week.view;

import com.bw.week.model.bean.LeiBiaoBean;
import com.bw.week.model.bean.LeiBiaoTwoBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName LeiBiaoItemView
 * @package com.bw.week.view
 * @date 2019/3/2/002 10:08
 */
public interface LeiBiaoItemView {
    void  getItemData(List<LeiBiaoTwoBean.ResultEntity> result);
}
