package max.jy.hzl.newgeeknews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import max.jy.hzl.newgeeknews.base.BaseActivity;
import max.jy.hzl.newgeeknews.bean.Constants;
import max.jy.hzl.newgeeknews.mokuai.about.AboutFragment;
import max.jy.hzl.newgeeknews.mokuai.collect.CollectFragment;
import max.jy.hzl.newgeeknews.mokuai.gank.GankFragment;
import max.jy.hzl.newgeeknews.mokuai.gold.GoldFragment;
import max.jy.hzl.newgeeknews.mokuai.setting.SettingFragment;
import max.jy.hzl.newgeeknews.mokuai.v2ex.V2EXFragment;
import max.jy.hzl.newgeeknews.mokuai.wechat.WechatFragment;
import max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment.SerchFragment;
import max.jy.hzl.newgeeknews.mokuai.zhihu.ZhiHuFragment;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tool)
    Toolbar mTool;
    @BindView(R.id.fl)
    FrameLayout mFl;
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.dl)
    DrawerLayout mDl;

    @BindView(R.id.search)
    MaterialSearchView search;

    private ArrayList<Integer> titles;
    private ArrayList<Fragment> fs;
    private FragmentManager manager;
    private int lastType;
    private int type;
    private MenuItem item;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @SuppressLint({"ResourceAsColor", "HandlerLeak"})
    @Override
    protected void initView() {
        initTitles();
        mTool.setTitle(titles.get(Constants.TYPE_ZHIHU));
        setSupportActionBar(mTool);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mTool, 0, 0);
        mDl.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();
        initFragment();




        FragmentUtils.addFragment(getSupportFragmentManager(),ZhiHuFragment.class,R.id.fl);
        search.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Bundle bundle = new Bundle();
                bundle.putString("data",query);

                FragmentUtils.addFragment(getSupportFragmentManager(),
                        SerchFragment.class,R.id.fl,bundle,true);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

//                Toast.makeText(MainActivity.this, "促发了：onQueryTextChange方法", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        search.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                Toast.makeText(MainActivity.this, "促发了：onSearchViewShown方法", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchViewClosed() {
                Toast.makeText(MainActivity.this, "促发了：onSearchViewClosed方法", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        fs = new ArrayList<>();
        fs.add(new ZhiHuFragment());
        fs.add(new WechatFragment());
        fs.add(new GankFragment());
        fs.add(new GoldFragment());
        fs.add(new V2EXFragment());
        fs.add(new CollectFragment());
        fs.add(new SettingFragment());
        fs.add(new AboutFragment());


    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.string.app_zhihu);
        titles.add(R.string.app_wechat);
        titles.add(R.string.app_gank);
        titles.add(R.string.app_gold);
        titles.add(R.string.app_vtex);
        titles.add(R.string.app_collect);
        titles.add(R.string.app_setting);
        titles.add(R.string.app_about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        item = menu.findItem(R.id.search);
        search.setMenuItem(item);//绑定searchview和item

        item.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void initListener() {
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);

                switch(item.getItemId()){
                    case R.id.zhihu:
                        switchTitle(Constants.TYPE_ZHIHU);
                        FragmentUtils.addFragment(getSupportFragmentManager(),ZhiHuFragment.class,R.id.fl);
                    break;

                    case R.id.wechat:
                        switchTitle(Constants.TYPE_WECHAT);
                        FragmentUtils.addFragment(getSupportFragmentManager(),WechatFragment.class,R.id.fl);
                        break;

                    case R.id.gank:
                        switchTitle(Constants.TYPE_GANK);
                        FragmentUtils.addFragment(getSupportFragmentManager(),GankFragment.class,R.id.fl);
                        break;


                    case R.id.gold:
                        switchTitle(Constants.TYPE_GOLD);
                        FragmentUtils.addFragment(getSupportFragmentManager(),GoldFragment.class,R.id.fl);
                        break;


                    case R.id.vtex:
                        switchTitle(Constants.TYPE_VTEX);
                        FragmentUtils.addFragment(getSupportFragmentManager(),V2EXFragment.class,R.id.fl);
                        break;


                    case R.id.collect:
                        switchTitle(Constants.TYPE_COLLECT);
                        FragmentUtils.addFragment(getSupportFragmentManager(),CollectFragment.class,R.id.fl);
                        break;


                    case R.id.setting:
                        switchTitle(Constants.TYPE_SETTING);
                        FragmentUtils.addFragment(getSupportFragmentManager(),SettingFragment.class,R.id.fl);
                        break;


                    case R.id.about:
                        switchTitle(Constants.TYPE_ABOUT);
                        FragmentUtils.addFragment(getSupportFragmentManager(),AboutFragment.class,R.id.fl);
                        break;

                }

                mDl.closeDrawers();
                return false;
            }
        });
        
    }

    private void switchTitle(int type) {

        mTool.setTitle(titles.get(type));

        if(type==Constants.TYPE_WECHAT||type==Constants.TYPE_GANK){
            item.setVisible(true);
        }else {
            item.setVisible(false);
        }

    }

    @Override
    public void onBackPressed() {

        if(search.isSearchOpen()){
            search.closeSearch();
        }else {
            super.onBackPressed();
        }
    }


}
