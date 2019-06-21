package max.jy.hzl.newgeeknews.mokuai.gold;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BasePresenter;

public class GoldP extends BasePresenter<GoldV,GoldM> {

    public void getData(String data){
        if(initMvpModel!=null){
            initMvpModel.getData(data, new BaseCallback<GoldBean>() {
                @Override
                public void getSuccessData(GoldBean goldBean) {
                    if(initMvpView!=null){

                        initMvpView.success(goldBean);
                    }
                }

                @Override
                public void getFailedData(String error) {
                    if(initMvpView!=null){

                        initMvpView.fail(error);
                    }
                }
            });
        }
    }
}
