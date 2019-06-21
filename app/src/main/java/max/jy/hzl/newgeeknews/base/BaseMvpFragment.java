package max.jy.hzl.newgeeknews.base;

public abstract class BaseMvpFragment<P extends BasePresenter, M extends BaseModel, V extends BaseView> extends BaseFragment {
    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter=initPresenter();
        if(myPresenter!=null){
            myPresenter.attachView(initMvpView());
            myPresenter.addModel(initMvpModel());
        }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(myPresenter!=null){
            myPresenter.destroy();
            myPresenter=null;
        }
    }
}
