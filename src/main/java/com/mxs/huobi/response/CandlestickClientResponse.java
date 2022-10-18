package com.mxs.huobi.response;

import com.mxs.huobi.dto.CandlestickClientDto;

import java.math.BigDecimal;
import java.util.List;

public class CandlestickClientResponse {
    private String ch;
    private String status;
    private BigDecimal ts;
    private List<CandlestickClientDto> data;

    public String getCh() {
        return ch;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTs() {
        return ts;
    }

    public List<CandlestickClientDto> getData() {
        return data;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTs(BigDecimal ts) {
        this.ts = ts;
    }

    public void setData(List<CandlestickClientDto> data) {
        this.data = data;
    }
}
