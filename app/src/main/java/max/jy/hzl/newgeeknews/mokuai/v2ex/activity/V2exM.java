package max.jy.hzl.newgeeknews.mokuai.v2ex.activity;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class V2exM extends BaseModel {
    public void getData(final BaseCallback<NodeNaviBean> nodeNaviBeanBaseCallback) {
        Observable<NodeNaviBean> data = HttpUtils.getInstance().getData(ApiService.mBaseUrl, ApiService.class).getNodeNavi();

        data.compose(RxUtils.<NodeNaviBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NodeNaviBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NodeNaviBean nodeNaviBean) {
                        if(nodeNaviBean!=null){
                            nodeNaviBeanBaseCallback.getSuccessData(nodeNaviBean);
                        }else {
                            nodeNaviBeanBaseCallback.getFailedData("");
                        }
                    }
                });
    }
}
