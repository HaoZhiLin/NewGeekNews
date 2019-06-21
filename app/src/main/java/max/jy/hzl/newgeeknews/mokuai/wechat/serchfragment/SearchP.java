package max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BasePresenter;

public class SearchP extends BasePresenter<SearchV,SearchM> {

    public void  getData(String data){
        if(initMvpModel!=null){
            initMvpModel.getData(data,new BaseCallback<SearchBean>() {
                @Override
                public void getSuccessData(SearchBean searchBean) {
                    if(initMvpView!=null){
                        initMvpView.getSuccessData(searchBean);
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
