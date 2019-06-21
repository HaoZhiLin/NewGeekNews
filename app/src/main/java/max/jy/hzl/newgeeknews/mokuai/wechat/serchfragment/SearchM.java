package max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class SearchM extends BaseModel {


    public void getData(String data, final BaseCallback<SearchBean> searchBeanBaseCallback) {
        Observable<SearchBean> searchData = HttpUtils.getInstance().getData(ApiService.searchUrl, ApiService.class)
                .getSearchData(data);
        searchData.compose(RxUtils.<SearchBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        if(searchBean!=null){
                            searchBeanBaseCallback.getSuccessData(searchBean);
                        }else {
                            searchBeanBaseCallback.getFailedData("请求失败！");
                        }
                    }
                });

    }
}
