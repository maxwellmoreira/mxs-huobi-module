package com.mxs.huobi.response;

import com.mxs.huobi.dto.CandlestickDto;

import java.util.List;

public class CandlestickResponse {
    private List<CandlestickDto> candlestickDtoList;

    public List<CandlestickDto> getCandlestickDtoList() {
        return candlestickDtoList;
    }

    public void setCandlestickDtoList(List<CandlestickDto> candlestickDtoList) {
        this.candlestickDtoList = candlestickDtoList;
    }
}
