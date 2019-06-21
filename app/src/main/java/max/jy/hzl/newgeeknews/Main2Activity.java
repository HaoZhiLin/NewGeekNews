package max.jy.hzl.newgeeknews;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import max.jy.hzl.newgeeknews.base.BaseActivity;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.web)
    WebView mWeb;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        super.initView();
        mWeb.setWebViewClient(new WebViewClient());
        String url = getIntent().getStringExtra("link");
        mWeb.loadUrl(url);


    }
}
