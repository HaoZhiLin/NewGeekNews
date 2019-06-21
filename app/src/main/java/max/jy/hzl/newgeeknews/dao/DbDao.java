package max.jy.hzl.newgeeknews.dao;


import java.util.ArrayList;

import max.jy.hzl.newgeeknews.mokuai.wechat.NewslistBean;
import max.jy.hzl.newgeeknews.utils.BaseApplication;

public class DbDao {
    public static NewslistBean  queryOne(NewslistBean newslistBean){

        return BaseApplication.getDaoSession().queryBuilder(NewslistBean.class)
                .where(NewslistBeanDao.Properties.Ctime.eq(newslistBean.getCtime()))
                .build()
                .unique();
    }


    public static  void  insert(NewslistBean newslistBean ){
        NewslistBean newslistBean1 = queryOne(newslistBean);
        if(newslistBean1==null){
            BaseApplication.getDaoSession().insert(newslistBean);
        }
    }

    public static  void  delete(NewslistBean newslistBean ){
        NewslistBean newslistBean1 = queryOne(newslistBean);
        if(newslistBean1!=null){
            BaseApplication.getDaoSession().delete(newslistBean);
        }
    }

    public static ArrayList<NewslistBean>  queryAll(){
        return (ArrayList<NewslistBean>) BaseApplication.getDaoSession().loadAll(NewslistBean.class);
    }

}
