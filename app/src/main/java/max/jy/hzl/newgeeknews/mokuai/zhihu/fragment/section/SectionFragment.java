package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseMvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectionFragment extends BaseMvpFragment<SectionP, SectionM, SectionV> implements SectionV {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private View view;
    private Unbinder unbinder;
    private SectionRlvAdapter adapter;

    @Override
    protected void initView(View view) {
        super.initView(view);
        mRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapter = new SectionRlvAdapter(getContext());
        mRlv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_section;
    }

    @Override
    protected SectionM initMvpModel() {
        return new SectionM();
    }

    @Override
    protected SectionV initMvpView() {
        return this;
    }

    @Override
    protected SectionP initPresenter() {
        return new SectionP();
    }

    @Override
    public void getSuccess(SectionBean sectionBean) {
        List<SectionBean.DataBean> data = sectionBean.getData();
        adapter.setList((ArrayList<SectionBean.DataBean>) data);
    }

    @Override
    public void getFailedData(String error) {

    }


}
