package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section;

import max.jy.hzl.newgeeknews.base.BaseView;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot.HotBean;

public interface SectionV extends BaseView {
    void getSuccess(SectionBean  sectionBean);

    void getFailedData(String error);
}
