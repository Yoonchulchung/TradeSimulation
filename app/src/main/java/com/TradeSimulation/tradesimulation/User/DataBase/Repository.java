package com.TradeSimulation.tradesimulation.User.DataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    //해당 클래스를 이용하여 데이터 접근한다.

    private final UserDao userDao;
    private final LiveData<List<UserDataBase>> liveData;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public Repository(Application application) {
        UserDB db = UserDB.getDB(application);
        userDao = db.userDao();
        liveData = userDao.viewAll();
    }

    LiveData<List<UserDataBase>> getAll() {
        return liveData;
    }

    public void insert(UserDataBase userDataBase) {
        UserDB.databaseWriteExecutor.execute(() ->
        {
            userDao.addTrade(userDataBase);
        });

    }


}
