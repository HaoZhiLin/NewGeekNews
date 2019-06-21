package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ZhiHuVpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment>  fragments;
    private String[] titles={"日报","热门","专栏"};

    public ZhiHuVpAdapter(FragmentManager fm,ArrayList<Fragment>  fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
