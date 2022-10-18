package com.mxs.huobi.type;

public enum CurrencyPairType {
    BTC_USDT("btcusdt");

    CurrencyPairType(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
