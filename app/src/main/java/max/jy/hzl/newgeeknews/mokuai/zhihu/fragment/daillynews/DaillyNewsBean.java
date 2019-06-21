package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews;

import java.util.List;

public class DaillyNewsBean {
    /**
     * date : 20190609
     * stories : [{"ga_prefix":"060920","id":9712254,"images":["https://pic2.zhimg.com/v2-ecad6b71d16a03a19df5cb60a1248239.jpg"],"multipic":true,"title":"《功夫》里包租公夫妇与火云邪神打成一团无法动弹的时候，周星驰为什么选择去打火云邪神？","type":0},{"ga_prefix":"060916","id":9712066,"images":["https://pic2.zhimg.com/v2-42603a6608d0162f64d88042e661e1f1.jpg"],"title":"为什么罐头里的食物要泡在水里？","type":0},{"ga_prefix":"060909","id":9712184,"images":["https://pic4.zhimg.com/v2-c561f264efa6b36603498e6eb3a06b77.jpg"],"title":"在影视、戏剧、文学等艺术形式中，有哪些借鉴电子游戏表现手法的实例？","type":0},{"ga_prefix":"060907","id":9712187,"images":["https://pic4.zhimg.com/v2-aaf445cb014977b4a8a7549b5021033f.jpg"],"title":"如果地球没有如《流浪地球》那样逃离，而是掉进了木星，人类会以怎样的形式死去？","type":0},{"ga_prefix":"060906","id":9711948,"images":["https://pic2.zhimg.com/v2-d3f0cadb427bf835f50c54b8b28173c1.jpg"],"title":"瞎扯 · 如何正确地吐槽","type":0}]
     * top_stories : [{"ga_prefix":"060407","id":9712095,"image":"https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg","title":"Uniqlo x KAWS 的发售「乱象」，是怎么出现的？","type":0},{"ga_prefix":"060408","id":9712142,"image":"https://pic1.zhimg.com/v2-cbc334204e7ffb639735367122eff48c.jpg","title":"旗帜鲜明地反对断骨增高手术","type":0},{"ga_prefix":"060308","id":9712046,"image":"https://pic1.zhimg.com/v2-96666b0894871ab0dbcf76dcccac6c40.jpg","title":"结婚 5 年，双方父母没见面，过年各回各家，Papi 酱的婚姻模式适合你吗？","type":0},{"ga_prefix":"053108","id":9712013,"image":"https://pic3.zhimg.com/v2-c041e9c1e28edc3100309532742509f2.jpg","title":"百度最难捱的一夜：五名高管闪电辞职内幕","type":0},{"ga_prefix":"053008","id":9711876,"image":"https://pic1.zhimg.com/v2-548d3d615b68aa27421475875d2b410c.jpg","title":"高铁这么好的东西，美国人为什么不大力发展？","type":0}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * ga_prefix : 060920
         * id : 9712254
         * images : ["https://pic2.zhimg.com/v2-ecad6b71d16a03a19df5cb60a1248239.jpg"]
         * multipic : true
         * title : 《功夫》里包租公夫妇与火云邪神打成一团无法动弹的时候，周星驰为什么选择去打火云邪神？
         * type : 0
         */

        private String ga_prefix;
        private int id;
        private boolean multipic;
        private String title;
        private int type;
        private List<String> images;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * ga_prefix : 060407
         * id : 9712095
         * image : https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg
         * title : Uniqlo x KAWS 的发售「乱象」，是怎么出现的？
         * type : 0
         */

        private String ga_prefix;
        private int id;
        private String image;
        private String title;
        private int type;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
