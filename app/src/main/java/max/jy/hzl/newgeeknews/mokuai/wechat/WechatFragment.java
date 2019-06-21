package max.jy.hzl.newgeeknews.mokuai.wechat;


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
import butterknife.Unbinder;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseMvpFragment;
import max.jy.hzl.newgeeknews.dao.DbDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseMvpFragment<WechatP, WechatM, WechatV> implements WechatV {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private View view;
    private Unbinder unbinder;
    private WechatRlvAdapter adapter;
    private List<NewslistBean> newslist;

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WechatRlvAdapter(getContext());
        mRlv.setAdapter(adapter);

        adapter.setOnClick(new WechatRlvAdapter.onClick() {
            @Override
            public void click(View v, int position) {
                NewslistBean newslistBean = newslist.get(position);
                DbDao.insert(newslistBean);
            }
        });


    }

    @Override
    protected void initData() {

        myPresenter.getWechatData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected WechatM initMvpModel() {
        return new WechatM();
    }

    @Override
    protected WechatV initMvpView() {
        return this;
    }

    @Override
    protected WechatP initPresenter() {
        return new WechatP();
    }

    @Override
    public void getSuccessData(WechatBean wechatBean) {
        newslist = wechatBean.getNewslist();
        adapter.setList((ArrayList<NewslistBean>) newslist);
    }

    private static final String TAG = "WechatFragment";

    @Override
    public void getFailedData(String error) {
        Log.e(TAG, "getFailedData: " + error);
    }


}
