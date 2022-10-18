package com.mxs.huobi.facade;

import com.mxs.huobi.request.CandlestickRequest;
import com.mxs.huobi.response.CandlestickResponse;
import com.mxs.huobi.strategy.CandlestickStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandlestickFacade {
    @Autowired
    private CandlestickStrategy candlestickStrategy;

    public CandlestickResponse listCandlestick(CandlestickRequest candlestickRequest) {
        return candlestickStrategy.listCandlestick(candlestickRequest);
    }
}
