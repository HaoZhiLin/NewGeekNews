package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

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
public class HotFragment extends BaseMvpFragment<HotP, HotM, HotV> implements HotV {


    @BindView(R.id.rlv_hot)
    RecyclerView mRlvHot;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;
    private HotRlvAdapter adapter;

    @Override
    protected void initView(View view) {
        super.initView(view);

        mRlvHot.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new HotRlvAdapter(getContext());
        mRlvHot.setAdapter(adapter);


        mSm.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                Toast.makeText(getContext(), "111111111", Toast.LENGTH_SHORT).show();
                refreshlayout.finishLoadmore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                Toast.makeText(getContext(), "222222222222", Toast.LENGTH_SHORT).show();
                refreshlayout.finishRefresh();
            }
        });

    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getHotData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected HotM initMvpModel() {
        return new HotM();
    }

    @Override
    protected HotV initMvpView() {
        return this;
    }

    @Override
    protected HotP initPresenter() {
        return new HotP();
    }

    @Override
    public void getSuccess(HotBean hotBean) {
        List<HotBean.RecentBean> recent = hotBean.getRecent();
        adapter.setList((ArrayList<HotBean.RecentBean>) recent);
    }

    private static final String TAG = "HotFragment";
    @Override
    public void getFailedData(String error) {
        Log.e(TAG, "getFailedData: "+error );
    }
}
