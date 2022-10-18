package com.mxs.huobi.type;

public enum PeriodType {
    ONE_MINUTE("1min"),
    FIVE_MINUTES("5min"),
    FIFTEEN_MINUTES("15min"),
    THIRTY_MINUTES("30min"),
    SIXTY_MINUTES("60min"),
    FOUR_HOURS("4hour"),
    ONE_DAY("1day"),
    ONE_MONTH("1mon"),
    ONE_WEEK("1week"),
    ONE_YEAR("1year");

    PeriodType(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
