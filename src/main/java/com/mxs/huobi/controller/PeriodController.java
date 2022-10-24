package com.mxs.huobi.controller;

import com.mxs.huobi.facade.PeriodFacade;
import com.mxs.huobi.request.PeriodRequest;
import com.mxs.huobi.response.PeriodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.mxs.huobi.constant.BaseUriConstant.PERIOD;

@Controller
@RequestMapping(value = PERIOD)
public class PeriodController {
    @Autowired
    private PeriodFacade periodFacade;

    @GetMapping("/candlestick-by-period")
    public ResponseEntity<PeriodResponse> listCandlestickByPeriod(@Valid PeriodRequest periodRequest) {
        return ResponseEntity.ok(periodFacade.listCandlestickByPeriod(periodRequest));
    }
}
