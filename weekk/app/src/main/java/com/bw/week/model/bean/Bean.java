package com.bw.week.model.bean;

/**
 * @author xuhongtao
 * @fileName Bean
 * @package com.bw.week.model.bean
 * @date 2019/2/28/028 20:35
 */
public class Bean<T> {
    private ShouYeBean.ResultEntity.MlssEntity mlss;
    private ShouYeBean.ResultEntity.PzshEntity pzsh;
    private ShouYeBean.ResultEntity.RxxpEntity rxxp;

    @Override
    public String toString() {
        return "Bean{" +
                "mlss=" + mlss +
                ", pzsh=" + pzsh +
                ", rxxp=" + rxxp +
                '}';
    }

    public Bean() {
    }

    public Bean(ShouYeBean.ResultEntity.MlssEntity mlss, ShouYeBean.ResultEntity.PzshEntity pzsh, ShouYeBean.ResultEntity.RxxpEntity rxxp) {
        this.mlss = mlss;
        this.pzsh = pzsh;
        this.rxxp = rxxp;
    }

    public ShouYeBean.ResultEntity.MlssEntity getMlss() {
        return mlss;
    }

    public void setMlss(ShouYeBean.ResultEntity.MlssEntity mlss) {
        this.mlss = mlss;
    }

    public ShouYeBean.ResultEntity.PzshEntity getPzsh() {
        return pzsh;
    }

    public void setPzsh(ShouYeBean.ResultEntity.PzshEntity pzsh) {
        this.pzsh = pzsh;
    }

    public ShouYeBean.ResultEntity.RxxpEntity getRxxp() {
        return rxxp;
    }

    public void setRxxp(ShouYeBean.ResultEntity.RxxpEntity rxxp) {
        this.rxxp = rxxp;
    }
}
