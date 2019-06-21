package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class DaillyNewsModel extends BaseModel {

    public void getData(final BaseCallback<DaillyNewsBean> daillyNewsBeanBaseCallback) {
        Observable<DaillyNewsBean> data = HttpUtils.getInstance().getData(ApiService.url, ApiService.class).getData();
        data.compose(RxUtils.<DaillyNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DaillyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DaillyNewsBean daillyNewsBean) {
                        if(daillyNewsBean!=null){
                            daillyNewsBeanBaseCallback.getSuccessData(daillyNewsBean);
                        }else {
                            daillyNewsBeanBaseCallback.getFailedData("解析错误");
                        }
                    }
                });

    }
}
