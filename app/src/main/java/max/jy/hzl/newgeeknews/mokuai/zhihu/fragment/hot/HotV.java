package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot;

import max.jy.hzl.newgeeknews.base.BaseView;

public interface HotV extends BaseView {
    void getSuccess(HotBean hotBean);

    void getFailedData(String error);
}
