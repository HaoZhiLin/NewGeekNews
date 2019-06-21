package max.jy.hzl.newgeeknews.mokuai.wechat;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class WechatM extends BaseModel {

    public void getData(final BaseCallback<WechatBean> baseCallback) {
        Observable<WechatBean> wechatData = HttpUtils.getInstance().getData(ApiService.WeCharUrl, ApiService.class).getWechatData();
        wechatData.compose(RxUtils.<WechatBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<WechatBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(WechatBean wechatBean) {
                if(wechatBean!=null){
                    baseCallback.getSuccessData(wechatBean);
                }else {
                    baseCallback.getFailedData("失败");
                }
            }
        });
    }
}
