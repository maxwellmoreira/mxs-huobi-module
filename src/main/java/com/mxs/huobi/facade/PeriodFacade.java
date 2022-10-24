package com.mxs.huobi.facade;

import com.mxs.huobi.factory.PeriodFactory;
import com.mxs.huobi.request.PeriodRequest;
import com.mxs.huobi.response.PeriodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodFacade {
    @Autowired
    private PeriodFactory periodFactory;

    public PeriodResponse listCandlestickByPeriod(PeriodRequest periodRequest) {
        return periodFactory.setPeriod(periodRequest.getPeriod()).listCandlestickByPeriod(periodRequest);
    }
}
