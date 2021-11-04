package com.TradeSimulation.tradesimulation.Language.Language;

public class KOR implements Language {


    @Override
    public String recentView() {
        return "최근 조회";
    }

    @Override
    public String globalChart() {
        return "해외 차트";
    }

    @Override
    public String digitalAssetChart() {
        return "가상 화폐";
    }

    @Override
    public String purchase() {
        return "결제되었습니다.";
    }

    @Override
    public String notEnoughMoney() {
        return "잔액이 부족합니다.";
    }

    @Override
    public String wrongMethod() {
        return "잘못된 방식입니다!";
    }

}
