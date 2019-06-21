package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section;

import max.jy.hzl.newgeeknews.base.BaseCallback;
import max.jy.hzl.newgeeknews.base.BasePresenter;

public class SectionP extends BasePresenter<SectionV,SectionM> {

    public void getData(){
        if(initMvpModel!=null){
            initMvpModel.getSectionData(new BaseCallback<SectionBean>() {
                @Override
                public void getSuccessData(SectionBean sectionBean) {
                    if(initMvpView!=null){
                        initMvpView.getSuccess(sectionBean);
                    }
                }

                @Override
                public void getFailedData(String error) {
                    if(initMvpView!=null){
                        initMvpView.getFailedData(error);
                    }
                }
            });
        }
    }
}
