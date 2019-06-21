package max.jy.hzl.newgeeknews.mokuai.v2ex.activity;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BasePresenter;

public class V2exP extends BasePresenter<V2exV,V2exM> {


    public void getData() {
        if(initMvpModel!=null){
            initMvpModel.getData(new BaseCallback<NodeNaviBean>() {
                @Override
                public void getSuccessData(NodeNaviBean nodeNaviBean) {
                    if(initMvpView!=null){
                        initMvpView.getSuccessData(nodeNaviBean);
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
