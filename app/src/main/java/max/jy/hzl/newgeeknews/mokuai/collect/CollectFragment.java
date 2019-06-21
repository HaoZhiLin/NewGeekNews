package max.jy.hzl.newgeeknews.mokuai.collect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseFragment;
import max.jy.hzl.newgeeknews.dao.DbDao;
import max.jy.hzl.newgeeknews.mokuai.wechat.NewslistBean;
import max.jy.hzl.newgeeknews.mokuai.wechat.WechatRlvAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private View view;
    private Unbinder unbinder;
    private WechatRlvAdapter adapter;

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager( new LinearLayoutManager(getContext()));

        adapter = new WechatRlvAdapter(getContext());
        mRlv.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        ArrayList<NewslistBean> newslistBeans = DbDao.queryAll();
        adapter.setList(newslistBeans);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }


}
