package com.mxs.huobi.contract;

import com.mxs.huobi.request.PeriodRequest;
import com.mxs.huobi.response.PeriodResponse;

public interface PeriodContract {
    PeriodResponse listCandlestickByPeriod(PeriodRequest periodRequest);
}
