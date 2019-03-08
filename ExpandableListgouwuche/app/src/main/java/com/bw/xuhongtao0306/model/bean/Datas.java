package com.bw.xuhongtao0306.model.bean;

/**
 * @author xuhongtao
 * @fileName Datas
 * @package com.bw.xuhongtao0306.model.bean
 * @date 2019/3/6/006 11:58
 */
public class Datas {
    private String created_at;
    private String name;
    private int praise_num;
    private int num;
    private String pic_url;
    private boolean itemChecked;

    @Override
    public String toString() {
        return "Datas{" +
                "created_at='" + created_at + '\'' +
                ", name='" + name + '\'' +
                ", praise_num=" + praise_num +
                ", num=" + num +
                ", pic_url='" + pic_url + '\'' +
                ", itemChecked=" + itemChecked +
                '}';
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public boolean isItemChecked() {
        return itemChecked;
    }

    public void setItemChecked(boolean itemChecked) {
        this.itemChecked = itemChecked;
    }

    public Datas() {
    }

    public Datas(String created_at, String name, int praise_num, int num, String pic_url, boolean itemChecked) {
        this.created_at = created_at;
        this.name = name;
        this.praise_num = praise_num;
        this.num = num;
        this.pic_url = pic_url;
        this.itemChecked = itemChecked;
    }
}
