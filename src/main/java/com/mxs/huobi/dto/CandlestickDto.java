package com.mxs.huobi.dto;

import java.math.BigDecimal;

public class CandlestickDto {
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }
}
