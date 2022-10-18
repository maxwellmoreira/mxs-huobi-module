package com.mxs.huobi.strategy;

import com.mxs.huobi.client.CandlestickClient;
import com.mxs.huobi.converter.CandlestickConverter;
import com.mxs.huobi.request.CandlestickRequest;
import com.mxs.huobi.response.CandlestickClientResponse;
import com.mxs.huobi.response.CandlestickResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandlestickStrategy {
    @Autowired
    private CandlestickClient candlestickClient;
    @Autowired
    private CandlestickConverter candlestickConverter;

    public CandlestickResponse listCandlestick(CandlestickRequest candlestickRequest) {
        CandlestickClientResponse candlestickClientResponse =
                candlestickClient.listCandlestick(
                        candlestickRequest.getSymbol().getCode(),
                        candlestickRequest.getPeriod().getCode(),
                        candlestickRequest.getSize());
        return candlestickConverter.convertToCandlestickResponse(candlestickClientResponse);
    }
}
