package max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import max.jy.hzl.newgeeknews.Main2Activity;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseMvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SerchFragment extends BaseMvpFragment<SearchP, SearchM, SearchV> implements SearchV {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private SearchRlvAdapter adapter;


    @Override
    protected void initView(View view) {
        super.initView(view);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new SearchRlvAdapter(getContext());
        mRlv.setAdapter(adapter);


        adapter.setOnClick(new SearchRlvAdapter.onClick() {
            @Override
            public void click(View v, String url) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void initData() {
        super.initData();

        Bundle bundle = getArguments();
        String data = bundle.getString("data");

        myPresenter.getData(data);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_serch;
    }

    @Override
    protected SearchM initMvpModel() {
        return new SearchM();
    }

    @Override
    protected SearchV initMvpView() {
        return this;
    }

    @Override
    protected SearchP initPresenter() {
        return new SearchP();
    }

    private static final String TAG = "SerchFragment";
    @Override
    public void getSuccessData(SearchBean searchBean) {
        List<SearchBean.NewslistBean> newslist = searchBean.getNewslist();
        adapter.setList((ArrayList<SearchBean.NewslistBean>) newslist);
    }

    @Override
    public void getFailedData(String error) {
        Log.e(TAG, "getFailedData: "+error );
    }
}
