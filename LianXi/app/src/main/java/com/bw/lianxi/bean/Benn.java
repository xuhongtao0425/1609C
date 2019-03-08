package com.bw.lianxi.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Benn
 * @package com.bw.lianxi.bean
 * @date 2019/2/28/028 15:51
 */
public class Benn {

     /**
     * result : [{"imageUrl":"http://172.17.8.100/images/small/banner/cj.png","rank":5,"title":"抽奖","jumpUrl":"http://172.17.8.100/htm/lottery/index.html"},{"imageUrl":"http://172.17.8.100/images/small/banner/hzp.png","rank":5,"title":"美妆工具","jumpUrl":"wd://commodity_list?arg=1001007005"},{"imageUrl":"http://172.17.8.100/images/small/banner/lyq.png","rank":5,"title":"连衣裙","jumpUrl":"wd://commodity_info?arg=83"},{"imageUrl":"http://172.17.8.100/images/small/banner/px.png","rank":5,"title":"跑鞋","jumpUrl":"wd://commodity_info?arg=165"},{"imageUrl":"http://172.17.8.100/images/small/banner/wy.png","rank":5,"title":"卫衣","jumpUrl":"wd://commodity_list?arg=1001002004"}]
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
         * imageUrl : http://172.17.8.100/images/small/banner/cj.png
         * rank : 5
         * title : 抽奖
         * jumpUrl : http://172.17.8.100/htm/lottery/index.html
         */
        private String imageUrl;
        private int rank;
        private String title;
        private String jumpUrl;

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public int getRank() {
            return rank;
        }

        public String getTitle() {
            return title;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }
    }
}
