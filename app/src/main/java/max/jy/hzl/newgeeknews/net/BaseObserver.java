package max.jy.hzl.newgeeknews.net;

import android.util.Log;

import io.reactivex.Observer;
import max.jy.hzl.newgeeknews.utils.ToastUtil;

/**
 * Created by $lzj on 2019/6/4.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private final String TAG = getClass().getName();

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: "+e.toString());
        ToastUtil.showShort("数据加载失败");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }

}
