package com.TradeSimulation.tradesimulation.User.DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.TradeSimulation.tradesimulation.Time.Time;
import com.TradeSimulation.tradesimulation.User.UserInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserDataBase.class}, version = 1)
public abstract class UserDB extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile UserDB INSTANCE;
    private static Time time = null;
    private static UserInfo userInfo = null;
    private static final RoomDatabase.Callback setInitialRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    databaseWriteExecutor.execute(() -> {
                        UserDao dao = INSTANCE.userDao();
                        dao.deleteAll();

                        //String tradeTime, String userName, int userID, String tradeList, int size,
                        //                        int entryPrice, int charge
                        UserDataBase userDataBase = new UserDataBase(time.getTime(),
                                userInfo.getUserName(),
                                userInfo.getUserID(),
                                "NONE",
                                0,
                                0.0,
                                String.valueOf(userInfo.getUserCharge()));
                        dao.addTrade(userDataBase);

                        userDataBase = new UserDataBase(time.getTime(),
                                userInfo.getUserName(),
                                userInfo.getUserID(),
                                "NONE",
                                0,
                                0.0,
                                String.valueOf(userInfo.getUserCharge()));
                        dao.addTrade(userDataBase);
                    });
                }
            };

    static UserDB getDB(final Context context) {
        time = new Time();
        userInfo = UserInfo.getInstance();

        if (INSTANCE == null) {
            synchronized (UserDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDB.class, "User_Info_version2")
                            .addCallback(setInitialRoomDatabaseCallback) // modified
                            .build();
                } else {

                }
            }
        } else {

        }
        return INSTANCE;
    }

    public abstract UserDao userDao();


}
