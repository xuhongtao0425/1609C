package com.bw.Week2.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Bean
 * @package com.bw.Week2.model.bean
 * @date 2019/2/23/023 11:37
 */
public class Bean {

    /**
     * result : [{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/4/1.jpg","price":119,"commodityId":145,"saleNum":0,"commodityName":"如熙新款男鞋韩版学生时尚百搭潮流低帮男帆布鞋简约英伦风舒适男板鞋轻便耐磨系带潮鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/5/1.jpg","price":109,"commodityId":139,"saleNum":0,"commodityName":"秋季男鞋简约百搭男小白鞋韩版潮流男板鞋跑步鞋子ins超火的运动鞋学生时尚嘻哈潮鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/2/1.jpg","price":99,"commodityId":136,"saleNum":0,"commodityName":"板鞋休闲鞋男男士休闲运动鞋男士鞋子休闲皮鞋男士休闲鞋男鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/7/1.jpg","price":99,"commodityId":141,"saleNum":0,"commodityName":"AUXTUN港仔原宿男鞋秋季鞋子男潮鞋百搭韩版潮流男士休闲鞋板鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/4/1.jpg","price":449,"commodityId":138,"saleNum":0,"commodityName":"秋男鞋时尚男士休闲鞋系带防磨脚男士皮鞋潮流休闲板鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/1/1.jpg","price":149,"commodityId":135,"saleNum":0,"commodityName":"青春时尚 潮流男鞋 韩版舒适简约百搭板鞋男士休闲鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/5/1.jpg","price":129,"commodityId":146,"saleNum":0,"commodityName":"时尚潮流 男鞋 套脚休闲板鞋帆布鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/6/1.jpg","price":398,"commodityId":140,"saleNum":0,"commodityName":"小白鞋男时尚新款运动休闲男鞋韩版潮流厚底原宿风板鞋"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/3/1.jpg","price":79,"commodityId":137,"saleNum":0,"commodityName":"唐狮冬季男士冬休闲鞋高帮男鞋男士板鞋休闲男鞋子高帮男鞋百搭休闲板鞋男"},{"masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/6/1.jpg","price":99,"commodityId":37,"saleNum":0,"commodityName":"轻便舒适 女鞋 简约百搭一脚蹬套脚女款板鞋休闲帆布鞋"}]
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
         * masterPic : http://172.17.8.100/images/small/commodity/nx/nfbx/4/1.jpg
         * price : 119
         * commodityId : 145
         * saleNum : 0
         * commodityName : 如熙新款男鞋韩版学生时尚百搭潮流低帮男帆布鞋简约英伦风舒适男板鞋轻便耐磨系带潮鞋
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
