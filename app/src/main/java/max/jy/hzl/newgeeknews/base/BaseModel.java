package max.jy.hzl.newgeeknews.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();

    public void clear() {
        compositeDisposable.clear();
    }
}
