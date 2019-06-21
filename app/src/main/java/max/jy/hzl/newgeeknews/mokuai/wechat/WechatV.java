package max.jy.hzl.newgeeknews.mokuai.wechat;

import max.jy.hzl.newgeeknews.base.BaseView;

public interface WechatV extends BaseView {
    void getSuccessData(WechatBean wechatBean);

    void getFailedData(String error);
}
