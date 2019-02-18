package com.bw.xuhongtao.model.bean;

import java.util.ArrayList;

/**
 * @author xuhongtao
 * @fileName Data
 * @package com.bw.xuhongtao.model.bean
 * @date 2019/2/18/018 9:34
 */
public class Data {
//    bindtips
//    data	Array
//    extras	Object
//    max_page	56
//    page	2
//    perpage	20
//    total	1114
    private String bindtips;
    private String max_page;
    private String page;
    private String perpage;
    private String total;
    private ArrayList<Datas> data;
    private Extras extras;

    @Override
    public String toString() {
        return "Data{" +
                "bindtips='" + bindtips + '\'' +
                ", max_page='" + max_page + '\'' +
                ", page='" + page + '\'' +
                ", perpage='" + perpage + '\'' +
                ", total='" + total + '\'' +
                ", data=" + data +
                ", extras=" + extras +
                '}';
    }

    public String getBindtips() {
        return bindtips;
    }

    public void setBindtips(String bindtips) {
        this.bindtips = bindtips;
    }

    public String getMax_page() {
        return max_page;
    }

    public void setMax_page(String max_page) {
        this.max_page = max_page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Datas> getData() {
        return data;
    }

    public void setData(ArrayList<Datas> data) {
        this.data = data;
    }

    public Extras getExtras() {
        return extras;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }
}
