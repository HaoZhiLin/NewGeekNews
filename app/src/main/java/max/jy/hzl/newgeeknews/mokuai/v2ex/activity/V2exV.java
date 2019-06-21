package max.jy.hzl.newgeeknews.mokuai.v2ex.activity;

import max.jy.hzl.newgeeknews.base.BaseView;

public interface V2exV extends BaseView {
    void getFailedData(String error);

    void getSuccessData(NodeNaviBean nodeNaviBean);
}

