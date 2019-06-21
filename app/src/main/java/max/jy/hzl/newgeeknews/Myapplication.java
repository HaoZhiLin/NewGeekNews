package max.jy.hzl.newgeeknews;

import android.app.Application;

import max.jy.hzl.newgeeknews.dao.DaoMaster;
import max.jy.hzl.newgeeknews.dao.DaoSession;

public class Myapplication extends Application {

    private static DaoSession daoSession;

    public static DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "user.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }
}
