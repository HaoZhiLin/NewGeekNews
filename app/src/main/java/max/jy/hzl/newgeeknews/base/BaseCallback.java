package max.jy.hzl.newgeeknews.base;

public interface BaseCallback<T> {
    void  getSuccessData(T t);
    void  getFailedData(String error);
}
