package max.jy.hzl.newgeeknews.mokuai.gold;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseMvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GoldChildFragment extends BaseMvpFragment<GoldP, GoldM, GoldV> implements GoldV {
    private ArrayList<GoldBean.ResultsBean> list;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private String name;
    private GoldAdapter adapter;

    @SuppressLint("ValidFragment")
    public GoldChildFragment(String name) {
        this.name = name;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList<>();
        adapter = new GoldAdapter(getContext(), list);
        mRlv.setAdapter(adapter);


    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData(name);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_child;
    }

    @Override
    protected GoldM initMvpModel() {
        return new GoldM();
    }

    @Override
    protected GoldV initMvpView() {
        return this;
    }

    @Override
    protected GoldP initPresenter() {
        return new GoldP();
    }

    @Override
    public void success(GoldBean goldBean) {
        List<GoldBean.ResultsBean> results = goldBean.getResults();
        list.addAll(results);
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "GoldChildFragment";
    @Override
    public void fail(String error) {
        Log.e(TAG, "fail: "+error );
    }


}


