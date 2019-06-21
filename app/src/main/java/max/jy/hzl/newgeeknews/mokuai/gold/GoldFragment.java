package max.jy.hzl.newgeeknews.mokuai.gold;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import max.jy.hzl.newgeeknews.Main3Activity;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseFragment;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldFragment extends BaseFragment {

    private String[] names={"all ", "Android ","iOS "," 休息视频 ",
            " 福利 "," 拓展资源 ","前端", "瞎推荐 "," App"};
    private ArrayList<GoldChildFragment> fragments;
    private ArrayList<TypeBean> types;
    private ArrayList<String> titles;

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;

    @BindView(R.id.iv)
    ImageView mIv;
    private GoldVpadapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

        types=new ArrayList<>();
        fragments=new ArrayList<>();
        titles=new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if(i%3==0){
                types.add(new TypeBean(names[i],true));
            }else {
                types.add(new TypeBean(names[i],false));
            }
        }


    }

    @Override
    protected void initData() {
        super.initData();

        for (int i = 0; i < types.size(); i++) {
            TypeBean typeBean = types.get(i);
            if(typeBean.isType()){
                titles.add(typeBean.getName());
                fragments.add(new GoldChildFragment(typeBean.getName()));

            }
        }


        adapter = new GoldVpadapter(getChildFragmentManager(), fragments, titles);
        mVp.setAdapter(adapter);

        mTab.setupWithViewPager(mVp);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Main3Activity.class);

                intent.putExtra("bean",types);
                startActivityForResult(intent,100);

//                getActivity().overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100&&resultCode==200){
            titles.clear();
            fragments.clear();
            types = (ArrayList<TypeBean>) data.getSerializableExtra("list");

            initData();
            adapter.notifyDataSetChanged();

        }
    }
}
