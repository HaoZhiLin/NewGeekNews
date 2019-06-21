package max.jy.hzl.newgeeknews.mokuai.v2ex;

public class V2exBean{
    private  String  author;
    private  int count;
    private  String img;
    private  String last;

    @Override
    public String toString() {
        return "V2exBean{" +
                "author='" + author + '\'' +
                ", count=" + count +
                ", img='" + img + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public V2exBean(String author, int count, String img, String last) {
        this.author = author;
        this.count = count;
        this.img = img;
        this.last = last;
    }
}
