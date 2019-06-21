package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class HotM extends BaseModel {
    public void getData(final BaseCallback<HotBean> baseCallback) {
        Observable<HotBean> hotData = HttpUtils.getInstance().getData(ApiService.url, ApiService.class).getHotData();
        hotData.compose(RxUtils.<HotBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<HotBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(HotBean hotBean) {
                if(hotBean!=null){
                    baseCallback.getSuccessData(hotBean);
                }else {
                    baseCallback.getFailedData("失败");
                }
            }
        });


    }
}
