package com.TradeSimulation.tradesimulation.User;

import com.TradeSimulation.tradesimulation.Language.LanguageEnum;
import com.TradeSimulation.tradesimulation.User.DataBase.RecentView;

import java.util.ArrayList;

public class UserInfo {

    public static double userCharge;
    static UserInfo userInfo = null;
    private String userName;
    private int userID;
    private LanguageEnum language;
    private ArrayList<RecentView> recentViewArrayList;
    private Boolean checkLogin;
    private int FirstActivityPosition = 0;

    private UserInfo() {
        recentViewArrayList = new ArrayList<RecentView>();
    }

    public static UserInfo getInstance() {
        if (userInfo == null) {
            userInfo = new UserInfo();
        } else {

        }
        return userInfo;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void finishInstance() {

        userInfo = null;
    }

    public double getUserCharge() {
        return userCharge;
    }

    public void setUserCharge(Double userCharge) {
        UserInfo.userCharge = userCharge;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public ArrayList<RecentView> getRecentViewArrayList() {
        return recentViewArrayList;
    }

    public void setRecentViewArrayList(ArrayList<RecentView> recentViewArrayList) {
        this.recentViewArrayList = recentViewArrayList;
    }

    public Boolean getCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(Boolean checkLogin) {
        this.checkLogin = checkLogin;
    }

    public int getFirstActivityPosition() {
        return FirstActivityPosition;
    }

    public void setFirstActivityPosition(int firstActivityPosition) {
        FirstActivityPosition = firstActivityPosition;
    }
}
