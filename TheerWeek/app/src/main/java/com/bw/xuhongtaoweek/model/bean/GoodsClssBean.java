package com.bw.xuhongtaoweek.model.bean;

import java.util.List;

/**
 * @author xuhongtao   二级列表
 * @fileName GoodsClssBean
 * @package com.bw.xuhongtaoweek.model.bean
 * @date 2019/3/7/007 14:58
 */
public class GoodsClssBean {


    public List<DataEntity> data;

    @Override
    public String toString() {
        return "GoodsClssBean{" +
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


        public List<ListEntity> list;
        public String name;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "list=" + list +
                    ", name='" + name + '\'' +
                    '}';
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public class ListEntity {


            public String name;
            public String icon;
            public int pscid;

            public ListEntity() {
            }

            public ListEntity(String name, String icon, int pscid) {
                this.name = name;
                this.icon = icon;
                this.pscid = pscid;
            }

            @Override
            public String toString() {
                return "ListEntity{" +
                        "name='" + name + '\'' +
                        ", icon='" + icon + '\'' +
                        ", pscid=" + pscid +
                        '}';
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }
        }
    }
}
