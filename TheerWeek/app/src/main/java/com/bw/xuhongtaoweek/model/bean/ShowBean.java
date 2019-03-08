package com.bw.xuhongtaoweek.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShowBean
 * @package com.bw.xuhongtaoweek.model.bean
 * @date 2019/3/7/007 17:34
 */
public class ShowBean {


    public List<DataEntity> data;

    @Override
    public String toString() {
        return "ShowBean{" +
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
        public String images;
        public double price;
        public int pid;
        public String detailUrl;
        public int pscid;
        public String title;

        public DataEntity() {
        }

        public DataEntity(String images, double price, int pid, String detailUrl, int pscid, String title) {
            this.images = images;
            this.price = price;
            this.pid = pid;
            this.detailUrl = detailUrl;
            this.pscid = pscid;
            this.title = title;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "images='" + images + '\'' +
                    ", price=" + price +
                    ", pid=" + pid +
                    ", detailUrl='" + detailUrl + '\'' +
                    ", pscid=" + pscid +
                    ", title='" + title + '\'' +
                    '}';
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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
    }
}
