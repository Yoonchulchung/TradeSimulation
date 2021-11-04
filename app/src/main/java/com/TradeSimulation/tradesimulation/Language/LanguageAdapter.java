package com.TradeSimulation.tradesimulation.Language;

import com.TradeSimulation.tradesimulation.Language.Language.CHN;
import com.TradeSimulation.tradesimulation.Language.Language.ENG;
import com.TradeSimulation.tradesimulation.Language.Language.KOR;
import com.TradeSimulation.tradesimulation.Language.Language.Language;
import com.TradeSimulation.tradesimulation.User.UserInfo;

public class LanguageAdapter implements com.TradeSimulation.tradesimulation.Language.Language.Language {

    public static LanguageAdapter languageAdapter = null;
    private static UserInfo userInfo = null;
    private Language language;

    private LanguageAdapter() {
        userInfo = UserInfo.getInstance();
        checkLanguage(userInfo.getLanguage());
    }

    public static LanguageAdapter getInstance() {
        if (languageAdapter == null) {
            languageAdapter = new LanguageAdapter();

        } else {

        }
        return languageAdapter;
    }

    public void checkLanguage(LanguageEnum language) {
        if (language == LanguageEnum.KOR) {
            this.setLanguage(new KOR());
        } else if (language == LanguageEnum.CHN) {
            this.setLanguage(new CHN());
        } else if (language == LanguageEnum.ENG) {
            this.setLanguage(new ENG());
        } else {
            this.setLanguage(new ENG());
        }

    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String recentView() {
        return language.recentView();
    }

    @Override
    public String globalChart() {
        return language.globalChart();
    }

    @Override
    public String digitalAssetChart() {
        return language.digitalAssetChart();
    }

    public String purchase() {
        return language.purchase();
    }

    public String notEnoughMoney() {
        return language.notEnoughMoney();
    }

    @Override
    public String wrongMethod() {
        return language.wrongMethod();
    }

}
