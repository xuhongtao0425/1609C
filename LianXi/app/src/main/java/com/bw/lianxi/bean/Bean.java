package com.bw.lianxi.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Bean
 * @package com.bw.lianxi.bean
 * @date 2019/2/28/028 15:50
 */
public class Bean {

    /**
     * result : {"rxxp":{"name":"热销新品","id":1002,"commodityList":[{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg","price":158,"commodityId":25,"saleNum":0,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/2/1.jpg","price":78,"commodityId":19,"saleNum":0,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/5/1.jpg","price":278,"commodityId":29,"saleNum":0,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲"}]},"pzsh":{"name":"品质生活","id":1004,"commodityList":[{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39,"commodityId":6,"saleNum":0,"commodityName":"轻柔系自然裸妆假睫毛"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44,"commodityId":13,"saleNum":0,"commodityName":"贝览得美妆蛋"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9,"commodityId":11,"saleNum":0,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39,"commodityId":5,"saleNum":156,"commodityName":"双头两用修容笔"}]},"mlss":{"name":"魔力时尚","id":1003,"commodityList":[{"masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88,"commodityId":32,"saleNum":0,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/6/1.jpg","price":12,"commodityId":16,"saleNum":0,"commodityName":"Lara style清洗剂"}]}}
     * message : 查询成功
     * status : 0000
     */
    private ResultEntity result;
    private String message;
    private String status;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public class ResultEntity {
        /**
         * rxxp : {"name":"热销新品","id":1002,"commodityList":[{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg","price":158,"commodityId":25,"saleNum":0,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/2/1.jpg","price":78,"commodityId":19,"saleNum":0,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/5/1.jpg","price":278,"commodityId":29,"saleNum":0,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲"}]}
         * pzsh : {"name":"品质生活","id":1004,"commodityList":[{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39,"commodityId":6,"saleNum":0,"commodityName":"轻柔系自然裸妆假睫毛"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44,"commodityId":13,"saleNum":0,"commodityName":"贝览得美妆蛋"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9,"commodityId":11,"saleNum":0,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39,"commodityId":5,"saleNum":156,"commodityName":"双头两用修容笔"}]}
         * mlss : {"name":"魔力时尚","id":1003,"commodityList":[{"masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88,"commodityId":32,"saleNum":0,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/6/1.jpg","price":12,"commodityId":16,"saleNum":0,"commodityName":"Lara style清洗剂"}]}
         */
        private RxxpEntity rxxp;
        private PzshEntity pzsh;
        private MlssEntity mlss;

        public void setRxxp(RxxpEntity rxxp) {
            this.rxxp = rxxp;
        }

        public void setPzsh(PzshEntity pzsh) {
            this.pzsh = pzsh;
        }

        public void setMlss(MlssEntity mlss) {
            this.mlss = mlss;
        }

        public RxxpEntity getRxxp() {
            return rxxp;
        }

        public PzshEntity getPzsh() {
            return pzsh;
        }

        public MlssEntity getMlss() {
            return mlss;
        }

        public class RxxpEntity {
            /**
             * name : 热销新品
             * id : 1002
             * commodityList : [{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg","price":158,"commodityId":25,"saleNum":0,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/2/1.jpg","price":78,"commodityId":19,"saleNum":0,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ddx/5/1.jpg","price":278,"commodityId":29,"saleNum":0,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲"}]
             */
            private String name;
            private int id;
            private List<CommodityListEntity> commodityList;

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setCommodityList(List<CommodityListEntity> commodityList) {
                this.commodityList = commodityList;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public List<CommodityListEntity> getCommodityList() {
                return commodityList;
            }

            public class CommodityListEntity {
                /**
                 * masterPic : http://172.17.8.100/images/small/commodity/nx/ddx/1/1.jpg
                 * price : 158
                 * commodityId : 25
                 * saleNum : 0
                 * commodityName : 秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋
                 */
                private String masterPic;
                private int price;
                private int commodityId;
                private int saleNum;
                private String commodityName;

                public void setMasterPic(String masterPic) {
                    this.masterPic = masterPic;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public void setCommodityId(int commodityId) {
                    this.commodityId = commodityId;
                }

                public void setSaleNum(int saleNum) {
                    this.saleNum = saleNum;
                }

                public void setCommodityName(String commodityName) {
                    this.commodityName = commodityName;
                }

                public String getMasterPic() {
                    return masterPic;
                }

                public int getPrice() {
                    return price;
                }

                public int getCommodityId() {
                    return commodityId;
                }

                public int getSaleNum() {
                    return saleNum;
                }

                public String getCommodityName() {
                    return commodityName;
                }
            }
        }

        public class PzshEntity {
            /**
             * name : 品质生活
             * id : 1004
             * commodityList : [{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39,"commodityId":6,"saleNum":0,"commodityName":"轻柔系自然裸妆假睫毛"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44,"commodityId":13,"saleNum":0,"commodityName":"贝览得美妆蛋"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9,"commodityId":11,"saleNum":0,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39,"commodityId":5,"saleNum":156,"commodityName":"双头两用修容笔"}]
             */
            private String name;
            private int id;
            private List<CommodityListEntity> commodityList;

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setCommodityList(List<CommodityListEntity> commodityList) {
                this.commodityList = commodityList;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public List<CommodityListEntity> getCommodityList() {
                return commodityList;
            }

            public class CommodityListEntity {
                /**
                 * masterPic : http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg
                 * price : 39
                 * commodityId : 6
                 * saleNum : 0
                 * commodityName : 轻柔系自然裸妆假睫毛
                 */
                private String masterPic;
                private int price;
                private int commodityId;
                private int saleNum;
                private String commodityName;

                public void setMasterPic(String masterPic) {
                    this.masterPic = masterPic;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public void setCommodityId(int commodityId) {
                    this.commodityId = commodityId;
                }

                public void setSaleNum(int saleNum) {
                    this.saleNum = saleNum;
                }

                public void setCommodityName(String commodityName) {
                    this.commodityName = commodityName;
                }

                public String getMasterPic() {
                    return masterPic;
                }

                public int getPrice() {
                    return price;
                }

                public int getCommodityId() {
                    return commodityId;
                }

                public int getSaleNum() {
                    return saleNum;
                }

                public String getCommodityName() {
                    return commodityName;
                }
            }
        }

        public class MlssEntity {
            /**
             * name : 魔力时尚
             * id : 1003
             * commodityList : [{"masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88,"commodityId":32,"saleNum":0,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/6/1.jpg","price":12,"commodityId":16,"saleNum":0,"commodityName":"Lara style清洗剂"}]
             */
            private String name;
            private int id;
            private List<CommodityListEntity> commodityList;

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setCommodityList(List<CommodityListEntity> commodityList) {
                this.commodityList = commodityList;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public List<CommodityListEntity> getCommodityList() {
                return commodityList;
            }

            public class CommodityListEntity {
                /**
                 * masterPic : http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg
                 * price : 88
                 * commodityId : 32
                 * saleNum : 0
                 * commodityName : 唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋
                 */
                private String masterPic;
                private int price;
                private int commodityId;
                private int saleNum;
                private String commodityName;

                public void setMasterPic(String masterPic) {
                    this.masterPic = masterPic;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public void setCommodityId(int commodityId) {
                    this.commodityId = commodityId;
                }

                public void setSaleNum(int saleNum) {
                    this.saleNum = saleNum;
                }

                public void setCommodityName(String commodityName) {
                    this.commodityName = commodityName;
                }

                public String getMasterPic() {
                    return masterPic;
                }

                public int getPrice() {
                    return price;
                }

                public int getCommodityId() {
                    return commodityId;
                }

                public int getSaleNum() {
                    return saleNum;
                }

                public String getCommodityName() {
                    return commodityName;
                }
            }
        }
    }
}
