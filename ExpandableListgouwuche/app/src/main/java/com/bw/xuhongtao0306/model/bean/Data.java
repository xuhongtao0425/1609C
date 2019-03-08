package com.bw.xuhongtao0306.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Data
 * @package com.bw.xuhongtao0306.model.bean
 * @date 2019/3/6/006 13:35
 */
public class Data {
    private List<Datas> spus;
    private String name;
    private boolean checked;

    @Override
    public String toString() {
        return "Data{" +
                "spus=" + spus +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }

    public List<Datas> getSpus() {
        return spus;
    }

    public void setSpus(List<Datas> spus) {
        this.spus = spus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Data() {
    }

    public Data(List<Datas> spus, String name, boolean checked) {
        this.spus = spus;
        this.name = name;
        this.checked = checked;
    }
}
