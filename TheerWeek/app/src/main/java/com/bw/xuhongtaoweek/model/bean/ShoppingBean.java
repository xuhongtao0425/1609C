package com.bw.xuhongtaoweek.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShoppingBean
 * @package com.bw.xuhongtaoweek.model.bean
 * @date 2019/3/7/007 18:23
 */
public class ShoppingBean {


    public List<DataEntity> data;

    @Override
    public String toString() {
        return "ShoppingBean{" +
                "data=" + data +
                '}';
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public class DataEntity {
        public boolean ischecked;
        public String sellerid;
        public String sellerName;
        public List<ListEntity> list;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "ischecked=" + ischecked +
                    ", sellerid='" + sellerid + '\'' +
                    ", sellerName='" + sellerName + '\'' +
                    ", list=" + list +
                    '}';
        }

        public boolean isIschecked() {
            return ischecked;
        }

        public void setIschecked(boolean ischecked) {
            this.ischecked = ischecked;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public class ListEntity {

            public String createtime;
            public String images;
            public int sellerid;
            public double price;
            public int num;
            public String subhead;
            public int pid;
            public String detailUrl;
            public int pscid;
            public String title;
            public int selected;
            public double bargainPrice;
            public boolean itchecked;

            public ListEntity() {
            }

            public ListEntity(String createtime, String images, int sellerid, double price, int num, String subhead, int pid, String detailUrl, int pscid, String title, int selected, double bargainPrice, boolean itchecked) {
                this.createtime = createtime;
                this.images = images;
                this.sellerid = sellerid;
                this.price = price;
                this.num = num;
                this.subhead = subhead;
                this.pid = pid;
                this.detailUrl = detailUrl;
                this.pscid = pscid;
                this.title = title;
                this.selected = selected;
                this.bargainPrice = bargainPrice;
                this.itchecked = itchecked;
            }

            @Override
            public String toString() {
                return "ListEntity{" +
                        "createtime='" + createtime + '\'' +
                        ", images='" + images + '\'' +
                        ", sellerid=" + sellerid +
                        ", price=" + price +
                        ", num=" + num +
                        ", subhead='" + subhead + '\'' +
                        ", pid=" + pid +
                        ", detailUrl='" + detailUrl + '\'' +
                        ", pscid=" + pscid +
                        ", title='" + title + '\'' +
                        ", selected=" + selected +
                        ", bargainPrice=" + bargainPrice +
                        ", itchecked=" + itchecked +
                        '}';
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getSellerid() {
                return sellerid;
            }

            public void setSellerid(int sellerid) {
                this.sellerid = sellerid;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getSelected() {
                return selected;
            }

            public void setSelected(int selected) {
                this.selected = selected;
            }

            public double getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(double bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public boolean isItchecked() {
                return itchecked;
            }

            public void setItchecked(boolean itchecked) {
                this.itchecked = itchecked;
            }
        }
    }
}
