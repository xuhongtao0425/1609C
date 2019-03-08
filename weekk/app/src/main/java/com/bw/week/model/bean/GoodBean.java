package com.bw.week.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName GoodBean
 * @package com.bw.week.model.bean
 * @date 2019/3/2/002 11:42
 */
public class GoodBean {

    /**
     * result : [{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/6/1.jpg","price":146,"commodityId":44,"saleNum":0,"commodityName":"新品女鞋秋冬水钻粗跟深口单鞋新款夏季网红同款高跟鞋仙女的鞋超火的鞋子婚鞋韩版百搭乖乖鞋温柔鞋尖头晚晚鞋一脚蹬"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/3/1.jpg","price":89,"commodityId":41,"saleNum":0,"commodityName":"秋季新品【羊皮】尖头亮片细高跟百搭女鞋浅口女鞋单鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/5/1.jpg","price":156,"commodityId":43,"saleNum":0,"commodityName":"舒适百搭浅口一字带休闲鞋高跟鞋女鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/2/1.jpg","price":146,"commodityId":40,"saleNum":0,"commodityName":"【反绒牛皮】秋季新品质感绒面真皮女鞋纯色舒适鞋垫透气百搭舒适耐磨防滑尖头粗跟中跟深口粗跟单鞋女鞋潮流尖头后拉链方跟中跟女鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/7/1.jpg","price":148,"commodityId":45,"saleNum":0,"commodityName":"【新品上市】秋季英伦风女鞋浅口婚鞋女单鞋女鞋职场工作鞋中跟时尚舒适尖头猫跟女单鞋网红鞋套脚细跟女鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/ggx/4/1.jpg","price":99,"commodityId":42,"saleNum":0,"commodityName":"【清仓】浅口尖头中空交叉带单鞋高跟鞋"}]
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
         * masterPic : http://172.17.8.100/images/small/commodity/nx/ggx/6/1.jpg
         * price : 146
         * commodityId : 44
         * saleNum : 0
         * commodityName : 新品女鞋秋冬水钻粗跟深口单鞋新款夏季网红同款高跟鞋仙女的鞋超火的鞋子婚鞋韩版百搭乖乖鞋温柔鞋尖头晚晚鞋一脚蹬
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
