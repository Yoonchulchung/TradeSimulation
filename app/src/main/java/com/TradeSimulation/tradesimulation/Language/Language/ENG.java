package com.TradeSimulation.tradesimulation.Language.Language;

public class ENG implements Language {

    @Override
    public String recentView() {
        return "Recent View";
    }

    @Override
    public String globalChart() {
        return "Global";
    }

    @Override
    public String digitalAssetChart() {
        return "Crypto";
    }

    @Override
    public String purchase() {
        return "Purchased";
    }

    @Override
    public String notEnoughMoney() {
        return "Not Enough Money";
    }

    @Override
    public String wrongMethod() {
        return "Wrong TradeMethod!";
    }


}
