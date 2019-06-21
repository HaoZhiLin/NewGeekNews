package max.jy.hzl.newgeeknews.mokuai.gold;

import java.io.Serializable;
import java.util.List;

public class GoldBean implements Serializable {

    /**
     * count : 10
     * error : false
     * results : [{"desc":"Test if all models in project correctly implement Parcelable","ganhuo_id":"574592bf6776594b0bcff7aa","publishedAt":"2016-05-26T11:52:42.430000","readability":"","type":"Android","url":"https://github.com/Commit451/ParcelCheck","who":"蒋朋"},{"desc":"A summary of all the Kotlin tips from Google's Android Developer #31DaysofKotlin on Twitter","ganhuo_id":"5aff4778421aa961c94cf577","publishedAt":"2018-05-12T00:00:00","readability":"","type":"Android","url":"https://github.com/andyb129/31DaysOfKotlin","who":"lijinshanmx"},{"desc":"Marvelous sliding square loader view inspired this Design All items has same gradient and it changing on depending items position","ganhuo_id":"5954ec49421aa90cb4724b46","publishedAt":"2017-07-19T13:23:20.375000","readability":"","type":"Android","url":"https://github.com/steelkiwi/SlidingSquareLoaderView","who":"Gavryschuk Yaroslav"},{"desc":"Archi - 用三种 Android 代码架构来重构一个应用","ganhuo_id":"56cc6d22421aa95caa70792d","publishedAt":"2015-10-15T11:01:18.103000","readability":"","type":"Android","url":"https://github.com/ivacf/archi","who":"AllenJuns"},{"desc":"基于Facebook Buck改造Android构建系统之初体验","ganhuo_id":"56cc6d22421aa95caa707930","publishedAt":"2015-10-20T03:45:36.970000","readability":"","type":"Android","url":"http://www.jianshu.com/p/1e990aac7836","who":"AllenJuns"},{"desc":"侧滑菜单流动效果","ganhuo_id":"56cc6d23421aa95caa707959","publishedAt":"2015-10-23T04:01:16.217000","readability":"","type":"Android","url":"https://github.com/mxn21/FlowingDrawer","who":"Jason"},{"desc":"一个垂直的ViewPager","ganhuo_id":"56cc6d22421aa95caa707948","publishedAt":"2015-10-19T03:47:21.650000","readability":"","type":"Android","url":"https://github.com/kaelaela/VerticalViewPager","who":"有时放纵"},{"desc":"给 App 提速：Android 性能优化总结","ganhuo_id":"56cc6d23421aa95caa707985","publishedAt":"2015-11-11T03:47:41.142000","readability":"","type":"Android","url":"http://android.jobbole.com/81944/","who":"有时放纵"},{"desc":"一个简化 Android 6.0 上权限处理的库。","ganhuo_id":"56cc6d23421aa95caa7079b7","publishedAt":"2015-11-17T04:00:01.763000","readability":"","type":"Android","url":"https://github.com/k0shk0sh/PermissionHelper","who":"Ailurus"},{"desc":"不同类型的loading动画效果","ganhuo_id":"56cc6d1d421aa95caa7077ec","publishedAt":"2015-08-25T04:08:30.731000","readability":"","type":"Android","url":"https://github.com/raweng/android-different-loading-animations","who":"Jason"}]
     */

    private int count;
    private boolean error;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * desc : Test if all models in project correctly implement Parcelable
         * ganhuo_id : 574592bf6776594b0bcff7aa
         * publishedAt : 2016-05-26T11:52:42.430000
         * readability :
         * type : Android
         * url : https://github.com/Commit451/ParcelCheck
         * who : 蒋朋
         */

        private String desc;
        private String ganhuo_id;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGanhuo_id() {
            return ganhuo_id;
        }

        public void setGanhuo_id(String ganhuo_id) {
            this.ganhuo_id = ganhuo_id;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
