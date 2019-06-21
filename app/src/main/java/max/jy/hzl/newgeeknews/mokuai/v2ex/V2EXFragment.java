package max.jy.hzl.newgeeknews.mokuai.v2ex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class V2EXFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_v2_ex, container, false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2_ex;
    }

    private static final String TAG = "V2EXFragment";
    @Override
    protected void initData() {
        super.initData();

    }
}
