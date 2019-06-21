package max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment;

import max.jy.hzl.newgeeknews.base.BaseView;
import max.jy.hzl.newgeeknews.mokuai.wechat.WechatBean;

public interface SearchV extends BaseView {
    void getSuccessData(SearchBean searchBean);

    void getFailedData(String error);
}
