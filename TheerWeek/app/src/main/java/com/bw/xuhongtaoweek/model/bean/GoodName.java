package com.bw.xuhongtaoweek.model.bean;

import java.util.List;

/**
 * @author xuhongtao    一级列表
 * @fileName GoodName
 * @package com.bw.xuhongtaoweek.model.bean
 * @date 2019/3/7/007 14:10
 */
public class GoodName {


    public List<DataEntity> data;

    @Override
    public String toString() {
        return "GoodName{" +
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
        public String name;
        public int cid;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "name='" + name + '\'' +
                    ", cid=" + cid +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public DataEntity() {
        }

        public DataEntity(String name, int cid) {
            this.name = name;
            this.cid = cid;
        }
    }
}
