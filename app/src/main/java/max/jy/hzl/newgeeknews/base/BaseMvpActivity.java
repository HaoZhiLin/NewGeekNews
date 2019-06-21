package max.jy.hzl.newgeeknews.base;

public  abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel, V extends  BaseView> extends BaseActivity{
    protected  P myPresenter;
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
    protected void onDestroy() {
        super.onDestroy();
        myPresenter.destroy();
        myPresenter=null;
    }
}
