package max.jy.hzl.newgeeknews;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import java.util.ArrayList;

import butterknife.BindView;
import max.jy.hzl.newgeeknews.base.BaseActivity;
import max.jy.hzl.newgeeknews.callback.SimpleItemTouchHelperCallback;
import max.jy.hzl.newgeeknews.mokuai.gold.LvAdapter;
import max.jy.hzl.newgeeknews.mokuai.gold.TypeBean;

public class Main3Activity extends BaseActivity {

    @BindView(R.id.lv)
    RecyclerView mLv;
    private ArrayList<TypeBean> list;
    private LvAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main3;
    }

    @Override
    protected void initView() {
        super.initView();
        mLv.setLayoutManager(new LinearLayoutManager(this));
        list = (ArrayList<TypeBean>) getIntent().getSerializableExtra("bean");
        adapter = new LvAdapter(this, list);
        mLv.setAdapter(adapter);


        SimpleItemTouchHelperCallback simple = new SimpleItemTouchHelperCallback(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simple);
        itemTouchHelper.attachToRecyclerView(mLv);


    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("list", adapter.list);
        setResult(200, intent);
        super.onBackPressed();
    }
}
