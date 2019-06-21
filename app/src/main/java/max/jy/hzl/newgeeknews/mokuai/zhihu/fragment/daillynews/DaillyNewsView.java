package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews;

import max.jy.hzl.newgeeknews.base.BaseView;

public interface DaillyNewsView extends BaseView {

    void getSuccess(DaillyNewsBean daillyNewsBean);

    void getFailedData(String error);
}
