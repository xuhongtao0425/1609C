package com.bw.xuhongtao.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Extras
 * @package com.bw.xuhongtao.model.bean
 * @date 2019/2/18/018 9:28
 */
public class Extras {
    private List<Dataa> slider;

    @Override
    public String toString() {
        return "Extras{" +
                "slider=" + slider +
                '}';
    }

    public List<Dataa> getSlider() {
        return slider;
    }

    public void setSlider(List<Dataa> slider) {
        this.slider = slider;
    }
}
