package max.jy.hzl.newgeeknews.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected ArrayList<BaseModel> list=new ArrayList<>();

    protected V initMvpView;
    protected M initMvpModel;

    public  void attachView(V initMvpView) {

        this.initMvpView = initMvpView;
    }

    public void addModel(M initMvpModel) {

        this.initMvpModel = initMvpModel;
        list.add(initMvpModel);
    }


    public void destroy() {
        if(initMvpModel!=null){
            initMvpModel=null;
        }

        if(list!=null&&list.size()>0){
            for (BaseModel baseModel : list) {
                baseModel.clear();
            }
        }

        if(initMvpView!=null){
            initMvpView=null;
        }

    }
}
