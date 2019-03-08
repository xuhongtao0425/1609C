package com.bw.week.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName SouSuoBean
 * @package com.bw.week.model.bean
 * @date 2019/3/1/001 20:17
 */
public class SouSuoBean {

    /**
     * result : [{"masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/3/1.jpg","price":89,"commodityId":109,"saleNum":0,"commodityName":"新款奢华镶钻镜面iphone xs max手机壳苹果7plusl软边时尚保护套"},{"masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/5/1.jpg","price":3799,"commodityId":104,"saleNum":0,"commodityName":"OPPO R17 全网通 8G+128G 美拍补光灯+美容补水仪套餐 全面屏AI智慧美颜双摄拍照手机"},{"masterPic":"http://172.17.8.100/images/small/commodity/sjsm/yyyl/6/1.jpg","price":39,"commodityId":119,"saleNum":0,"commodityName":"斯泰克 吃鸡神器手游键盘 快捷射击辅助按键四指手机游戏 绝地求生刺激战场游戏手柄合金款 苹果安卓通用 扳机射击按键（2件装）"},{"masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/1/1.jpg","price":10069,"commodityId":100,"saleNum":0,"commodityName":"【壳膜线套餐】 苹果 iPhone XS 256G 全网通手机"},{"masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/1.jpg","price":39,"commodityId":111,"saleNum":0,"commodityName":"三合一充电器数据线苹果二合一拖安卓手机多用功能多头车载苹果安卓一拖三数据线Type-C铝合金编织线 土豪金"}]
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
         * masterPic : http://172.17.8.100/images/small/commodity/sjsm/sjpj/3/1.jpg
         * price : 89
         * commodityId : 109
         * saleNum : 0
         * commodityName : 新款奢华镶钻镜面iphone xs max手机壳苹果7plusl软边时尚保护套
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
