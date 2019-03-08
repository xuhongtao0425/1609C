package com.bw.week.model.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName LeiBiaoTwoBean
 * @package com.bw.week.model.bean
 * @date 2019/3/2/002 10:02
 */
public class LeiBiaoTwoBean {

    /**
     * result : [{"name":"手机","id":"1001008001"},{"name":"手机配件","id":"1001008002"},{"name":"照相机","id":"1001008003"},{"name":"影音娱乐","id":"1001008004"},{"name":"智能设备","id":"1001008005"}]
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
         * name : 手机
         * id : 1001008001
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
