package com.bw.Week2.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Bean
 * @package com.bw.Week2.model.bean
 * @date 2019/2/22/022 19:36
 */
public class Bean {

    /**
     * result : [{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg","price":99,"commodityId":42,"saleNum":0,"commodityName":"【清仓】浅口尖头中空交叉带单鞋高跟鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/6/1.jpg","price":146,"commodityId":44,"saleNum":0,"commodityName":"新品女鞋秋冬水钻粗跟深口单鞋新款夏季网红同款高跟鞋仙女的鞋超火的鞋子婚鞋韩版百搭乖乖鞋温柔鞋尖头晚晚鞋一脚蹬"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/1/1.jpg","price":158,"commodityId":39,"saleNum":0,"commodityName":"热销爆款人气女鞋单鞋时尚金属装饰女高跟鞋尖头浅口中空单鞋通勤百搭粗跟高跟鞋女单鞋女鞋高跟方跟套脚单鞋办公室约会气质百搭"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/5/1.jpg","price":156,"commodityId":43,"saleNum":0,"commodityName":"舒适百搭浅口一字带休闲鞋高跟鞋女鞋"}]
     * message : 查询成功
     * status : 0000
     */
    private List<ResultEntity> result;
    private String message;
    private String status;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultEntity> getResult() {
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
         * masterPic : http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg
         * price : 99
         * commodityId : 42
         * saleNum : 0
         * commodityName : 【清仓】浅口尖头中空交叉带单鞋高跟鞋
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
