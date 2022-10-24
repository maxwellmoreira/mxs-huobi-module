package com.mxs.huobi.converter;

import com.mxs.huobi.request.CandlestickRequest;
import com.mxs.huobi.request.PeriodRequest;
import org.springframework.stereotype.Component;

@Component
public class PeriodConverter {
    public CandlestickRequest convertToCandlestickRequest(PeriodRequest periodRequest) {
        CandlestickRequest candlestickRequest = new CandlestickRequest();
        candlestickRequest.setSymbol(periodRequest.getSymbol());
        candlestickRequest.setPeriod(periodRequest.getPeriod());
        candlestickRequest.setSize(periodRequest.getSize());
        return candlestickRequest;
    }
}
