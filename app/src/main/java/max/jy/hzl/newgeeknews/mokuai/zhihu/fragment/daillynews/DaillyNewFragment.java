package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseMvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaillyNewFragment extends BaseMvpFragment<DaillyNewsPresenterl,DaillyNewsModel,DaillyNewsView> implements DaillyNewsView{


    @BindView(R.id.dailly_rlv)
    RecyclerView mDaillyRlv;
    private View view;
    private Unbinder unbinder;
    private DaillyNewsRlvAdapter adapter;
    private List<DaillyNewsBean.TopStoriesBean> top_stories;
    private List<DaillyNewsBean.StoriesBean> stories;
    private String date;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dailly_new;
    }

    @Override
    protected void initView(View view) {
        mDaillyRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DaillyNewsRlvAdapter(getContext());
        mDaillyRlv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

        myPresenter.getData();
    }

    @Override
    protected DaillyNewsModel initMvpModel() {
        return new DaillyNewsModel();
    }

    @Override
    protected DaillyNewsView initMvpView() {
        return this;
    }

    @Override
    protected DaillyNewsPresenterl initPresenter() {
        return new DaillyNewsPresenterl();
    }


    @Override
    public void getSuccess(DaillyNewsBean daillyNewsBean) {
        date = daillyNewsBean.getDate();
        top_stories = daillyNewsBean.getTop_stories();
        stories = daillyNewsBean.getStories();

        adapter.setDate(date);
        adapter.setStories(stories);
        adapter.setTop_stories(top_stories);
    }

    @Override
    public void getFailedData(String error) {

    }
}
