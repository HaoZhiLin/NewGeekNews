package max.jy.hzl.newgeeknews.mokuai.gold;

import max.jy.hzl.newgeeknews.base.BaseView;

public interface GoldV extends BaseView {
    void success(GoldBean goldBean);
    void fail(String error);

}
