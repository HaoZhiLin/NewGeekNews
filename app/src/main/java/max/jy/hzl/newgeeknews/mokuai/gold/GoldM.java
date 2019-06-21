package max.jy.hzl.newgeeknews.mokuai.gold;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class GoldM extends BaseModel {
    public void getData(String data, final BaseCallback<GoldBean> goldBeanBaseCallback) {
        Observable<GoldBean> goldData = HttpUtils.getInstance().getData(ApiService.goldUrl, ApiService.class).getGoldData(data);
        goldData.compose(RxUtils.<GoldBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<GoldBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(GoldBean goldBean) {
                if(goldBean!=null){
                    goldBeanBaseCallback.getSuccessData(goldBean);
                }else {
                    goldBeanBaseCallback.getFailedData("");
                }
            }
        });
    }
}
