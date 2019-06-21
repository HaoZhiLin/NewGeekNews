package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BasePresenter;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews.DaillyNewsBean;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews.DaillyNewsModel;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews.DaillyNewsView;

public class HotP extends BasePresenter<HotV,HotM> {
    public void getHotData(){
        if(initMvpModel!=null){
            initMvpModel.getData(new BaseCallback<HotBean>() {
                @Override
                public void getSuccessData(HotBean hotBean) {
                    if(initMvpView!=null){
                        initMvpView.getSuccess(hotBean);
                    }
                }

                @Override
                public void getFailedData(String error) {
                    if(initMvpView!=null){
                        initMvpView.getFailedData(error);
                    }
                }
            });
        }
    }

}
