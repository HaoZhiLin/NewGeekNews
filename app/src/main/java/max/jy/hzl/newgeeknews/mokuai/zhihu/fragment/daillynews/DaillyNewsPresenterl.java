package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BasePresenter;

public class DaillyNewsPresenterl extends BasePresenter<DaillyNewsView,DaillyNewsModel> {

    public void getData() {
        if(initMvpModel!=null){
            initMvpModel.getData(new BaseCallback<DaillyNewsBean>() {
                @Override
                public void getSuccessData(DaillyNewsBean daillyNewsBean) {
                    if(initMvpView!=null){

                        initMvpView.getSuccess(daillyNewsBean);
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
