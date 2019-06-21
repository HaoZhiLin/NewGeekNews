package max.jy.hzl.newgeeknews.mokuai.v2ex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import max.jy.hzl.newgeeknews.Main2Activity;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseActivity;
import max.jy.hzl.newgeeknews.base.BaseMvpActivity;
import max.jy.hzl.newgeeknews.utils.ToastUtil;
import qdx.stickyheaderdecoration.NormalDecoration;

public class V2exActivity extends BaseMvpActivity<V2exP,V2exM,V2exV> implements V2exV {
    private static final String TAG = "V2exActivity";
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ArrayList<NodeNaviBean.DataBean> list;
    private RlvNodeNaviAdapter adapter;


    @Override
    protected void initData() {
        super.initData();

        myPresenter.getData();
    }

    @Override
    protected V2exM initMvpModel() {
        return new V2exM();
    }

    @Override
    protected V2exV initMvpView() {
        return this;
    }

    @Override
    protected V2exP initPresenter() {
        return new V2exP();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_v2ex;
    }



    @Override
    protected void initView() {
        super.initView();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RlvNodeNaviAdapter(this, list);

        mRlv.setAdapter(adapter);
        adapter.setOnClick(new RlvNodeNaviAdapter.onClick() {
            @Override
            public void click(View v, int groupPosition, int chilePosition) {
                String link = adapter.getList().get(groupPosition).getArticles().get(chilePosition).getLink();
                Intent intent = new Intent(V2exActivity.this, Main2Activity.class);
                intent.putExtra("link",link);
                startActivity(intent);

            }
        });

    }

    @Override
    public void getFailedData(String error) {
        Log.e(TAG, "getFailedData: "+error );
    }

    @Override
    public void getSuccessData(NodeNaviBean nodeNaviBean) {
        final List<NodeNaviBean.DataBean> data = nodeNaviBean.getData();

        NormalDecoration normalDecoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return data.get(i).getName();
            }
        };
        mRlv.addItemDecoration(normalDecoration);

        list.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
