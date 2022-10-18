package com.mxs.huobi.request;

import com.mxs.huobi.type.CurrencyPairType;
import com.mxs.huobi.type.PeriodType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CandlestickRequest {
    @NotNull(message = "Symbol is null")
    private CurrencyPairType symbol;
    @NotNull(message = "Period is null")
    private PeriodType period;
    @Min(value = 1, message = "Size should not be less than 1")
    private int size;

    public CurrencyPairType getSymbol() {
        return symbol;
    }

    public PeriodType getPeriod() {
        return period;
    }

    public int getSize() {
        return size;
    }

    public void setSymbol(CurrencyPairType symbol) {
        this.symbol = symbol;
    }

    public void setPeriod(PeriodType period) {
        this.period = period;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
