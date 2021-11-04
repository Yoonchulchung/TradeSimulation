package com.TradeSimulation.tradesimulation.User.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class UserDataBase {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "TradeTime")
    public String tradeTime;

    @ColumnInfo(name = "UserName")
    @NotNull
    public String userName;

    @ColumnInfo(name = "UserID")
    @NotNull
    public int userID;

    @ColumnInfo(name = "Currency")
    @NotNull
    public String currency;

    @ColumnInfo(name = "Size")
    @NotNull
    public int size;

    @ColumnInfo(name = "EntryPrice")
    @NotNull
    public Double entryPrice;

    @ColumnInfo(name = "Charge")
    @NotNull
    public String charge;

    public UserDataBase(String tradeTime, String userName, int userID, String currency, int size,
                        Double entryPrice, String charge) {
        this.tradeTime = tradeTime;
        this.userName = userName;
        this.userID = userID;
        this.currency = currency;
        this.size = size;
        this.entryPrice = entryPrice;
        this.charge = charge;
    }


    @NotNull
    public String getUserName() {
        return userName;
    }

    @NotNull
    public int getUserID() {
        return userID;
    }

    @NotNull
    public String getTradeList() {
        return currency;
    }

    @NotNull
    public int getSize() {
        return size;
    }

    @NotNull
    public Double getEntryPrice() {
        return entryPrice;
    }

    @NotNull
    public String getTradeTime() {
        return tradeTime;
    }

    @NotNull
    public String getCharge() {
        return charge;
    }


}

