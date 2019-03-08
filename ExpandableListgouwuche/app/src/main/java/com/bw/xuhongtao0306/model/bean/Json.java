package com.bw.xuhongtao0306.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName Json
 * @package com.bw.xuhongtao0306.model.bean
 * @date 2019/3/6/006 11:57
 */
public class Json {
    private List<Data> data;

    @Override
    public String toString() {
        return "Json{" +
                "data=" + data +
                '}';
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
