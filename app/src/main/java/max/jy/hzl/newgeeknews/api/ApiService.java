package max.jy.hzl.newgeeknews.api;


import io.reactivex.Observable;
import max.jy.hzl.newgeeknews.mokuai.gold.GoldBean;
import max.jy.hzl.newgeeknews.mokuai.v2ex.activity.NodeNaviBean;
import max.jy.hzl.newgeeknews.mokuai.wechat.WechatBean;
import max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment.SearchBean;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews.DaillyNewsBean;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot.HotBean;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section.SectionBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

//
//     2)最新日报
//     news/latest
//     3)往期日报
//     news/before/{date}   日期格式(20181206)
//     4)主题日报
//     themes   无数据
//     5)专栏日报
//            sections
//     6)专栏日报详情
//     section/{id} 参数id上一个接口中
//     7热门日报
//     news/hot


    String url="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<DaillyNewsBean> getData();


    @GET("news/hot")
    Observable<HotBean> getHotData();

    @GET("sections")
    Observable<SectionBean> getSectionData();



    public String WeCharUrl = "http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBean> getWechatData();


//    wxnew(http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1&word="我")
//
//            参数：key=52b7ec3471ac3bec6846577e79f20e4c
//
//            num(每页的数量)
//
//    page(页码)
//
//    word(关键字检索)

    String searchUrl="http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<SearchBean> getSearchData(@Query("word") String word);



//    http://gank.io/api/search/query/{all}/category/Android/count/10/page/1
//    category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
//    count 最大 50

    String goldUrl="http://gank.io/";

    @GET("api/search/query/{data}/category/Android/count/10/page/1")
    Observable<GoldBean> getGoldData(@Path("data") String data);


    //节点列表
    String mBaseUrl = "https://www.wanandroid.com/";
    @GET("navi/json")
    Observable<NodeNaviBean> getNodeNavi();

}
