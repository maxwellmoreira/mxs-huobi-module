package com.mxs.huobi.dto;

import java.math.BigDecimal;

public class CandlestickClientDto {
    private BigDecimal id;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal amount;
    private BigDecimal vol;
    private BigDecimal count;

    public BigDecimal getId() {
        return id;
    }

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

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
