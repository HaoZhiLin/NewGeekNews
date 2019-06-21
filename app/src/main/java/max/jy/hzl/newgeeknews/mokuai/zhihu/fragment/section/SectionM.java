package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import max.jy.hzl.newgeeknews.api.ApiService;
import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BaseModel;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot.HotBean;
import max.jy.hzl.newgeeknews.net.BaseObserver;
import max.jy.hzl.newgeeknews.net.HttpUtils;
import max.jy.hzl.newgeeknews.net.RxUtils;

public class SectionM extends BaseModel {
    public void getSectionData(final BaseCallback<SectionBean> baseCallback) {
        Observable<SectionBean> sectionData = HttpUtils.getInstance().getData(ApiService.url, ApiService.class).getSectionData();
        sectionData.compose(RxUtils.<SectionBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<SectionBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(SectionBean sectionBean) {
                    if(sectionBean!=null){
                        baseCallback.getSuccessData(sectionBean);
                    }else{
                        baseCallback.getFailedData("失败");
                    }
            }
        });

    }
}
