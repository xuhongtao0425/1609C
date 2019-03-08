package com.bw.week.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName LeiBiaoBean
 * @package com.bw.week.model.bean
 * @date 2019/3/2/002 9:08
 */
public class LeiBiaoBean {

    /**
     * result : [{"name":"女装","id":"1001002"},{"name":"男鞋","id":"1001003"},{"name":"女鞋","id":"1001004"},{"name":"美妆护肤","id":"1001007"},{"name":"手机数码","id":"1001008"},{"name":"箱包手袋","id":"1001005"}]
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
         * name : 女装
         * id : 1001002
         */
        private String name;
        private String id;

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }
}
