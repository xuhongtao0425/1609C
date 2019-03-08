package com.bw.lianxi.bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Beans
 * @package com.bw.lianxi.bean
 * @date 2019/2/28/028 15:52
 */
public class Beans<T> {
    private List<Benn.ResultEntity> list;
    private Bean.ResultEntity.RxxpEntity rxxp;
    private Bean.ResultEntity.PzshEntity pzsh;
    private Bean.ResultEntity.MlssEntity mlss;

    public Beans() {
    }

    public Beans(List<Benn.ResultEntity> list, Bean.ResultEntity.RxxpEntity rxxp, Bean.ResultEntity.PzshEntity pzsh, Bean.ResultEntity.MlssEntity mlss) {
        this.list = list;
        this.rxxp = rxxp;
        this.pzsh = pzsh;
        this.mlss = mlss;
    }

    @Override
    public String toString() {
        return "Beans{" +
                "list=" + list +
                ", rxxp=" + rxxp +
                ", pzsh=" + pzsh +
                ", mlss=" + mlss +
                '}';
    }

    public List<Benn.ResultEntity> getList() {
        return list;
    }

    public void setList(List<Benn.ResultEntity> list) {
        this.list = list;
    }

    public Bean.ResultEntity.RxxpEntity getRxxp() {
        return rxxp;
    }

    public void setRxxp(Bean.ResultEntity.RxxpEntity rxxp) {
        this.rxxp = rxxp;
    }

    public Bean.ResultEntity.PzshEntity getPzsh() {
        return pzsh;
    }

    public void setPzsh(Bean.ResultEntity.PzshEntity pzsh) {
        this.pzsh = pzsh;
    }

    public Bean.ResultEntity.MlssEntity getMlss() {
        return mlss;
    }

    public void setMlss(Bean.ResultEntity.MlssEntity mlss) {
        this.mlss = mlss;
    }
}
