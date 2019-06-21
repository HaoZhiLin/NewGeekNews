package max.jy.hzl.newgeeknews.mokuai.gold;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class GoldVpadapter extends FragmentStatePagerAdapter {

    private ArrayList<GoldChildFragment> fragments;
    private ArrayList<String> titles;

    public GoldVpadapter(FragmentManager fm, ArrayList<GoldChildFragment> fragments, ArrayList<String> titles) {

        super(fm);
        this.fragments = fragments;
        this.titles = titles;
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
        return titles.get(position);
    }
}
