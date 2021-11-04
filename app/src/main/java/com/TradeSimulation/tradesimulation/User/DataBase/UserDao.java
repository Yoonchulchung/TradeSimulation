package com.TradeSimulation.tradesimulation.User.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * from UserDataBase")
    LiveData<List<UserDataBase>> viewAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrade(UserDataBase userDataBase);

    @Query("DELETE FROM UserDataBase")
    void deleteAll();


}
