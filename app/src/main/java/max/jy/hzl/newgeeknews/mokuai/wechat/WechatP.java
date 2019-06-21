package max.jy.hzl.newgeeknews.mokuai.wechat;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.base.BasePresenter;

public class WechatP extends BasePresenter<WechatV,WechatM> {

    public void getWechatData(){
        if(initMvpModel!=null){
            initMvpModel.getData(new BaseCallback<WechatBean>() {
                @Override
                public void getSuccessData(WechatBean wechatBean) {
                    if(initMvpView!=null){
                        initMvpView.getSuccessData(wechatBean);
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
