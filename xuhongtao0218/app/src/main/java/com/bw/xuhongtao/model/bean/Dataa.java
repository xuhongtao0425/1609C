package com.bw.xuhongtao.model.bean;

/**
 * @author xuhongtao
 * @fileName Dataa
 * @package com.bw.xuhongtao.model.bean
 * @date 2019/2/18/018 9:25
 */
public class Dataa {
//    id	3697335
////    inner_news	1
////    link	lsapp://cn.ahurls.news/news?id=3697335
////    pic	19/0217/5c6929696a9fd.jpg
////    t	url
////    title	合肥节后错峰游机票低至2折
////    type	nomal
////    type_sign
    private String id;
    private String inner_news;
    private String link;
    private String pic;
    private String t;
    private String title;
    private String type;
    private String type_sign;

    @Override
    public String toString() {
        return "Dataa{" +
                "id='" + id + '\'' +
                ", inner_news='" + inner_news + '\'' +
                ", link='" + link + '\'' +
                ", pic='" + pic + '\'' +
                ", t='" + t + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", type_sign='" + type_sign + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInner_news() {
        return inner_news;
    }

    public void setInner_news(String inner_news) {
        this.inner_news = inner_news;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_sign() {
        return type_sign;
    }

    public void setType_sign(String type_sign) {
        this.type_sign = type_sign;
    }
}
