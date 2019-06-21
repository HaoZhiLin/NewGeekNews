package max.jy.hzl.newgeeknews.mokuai.zhihu;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;
import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseFragment;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.ZhiHuVpAdapter;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews.DaillyNewFragment;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot.HotFragment;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section.SectionFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiHuFragment extends BaseFragment {


    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private View view;
    private Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private ZhiHuVpAdapter vpada;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi_hu;
    }

    @Override
    protected void initView(View view) {
        mTab.setupWithViewPager(mVp);
        initFragment();
        vpada = new ZhiHuVpAdapter(getChildFragmentManager(), fragments);
        mVp.setAdapter(vpada);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new DaillyNewFragment());
        fragments.add(new HotFragment());
        fragments.add(new SectionFragment());

    }

}
