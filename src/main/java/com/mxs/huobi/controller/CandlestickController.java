package com.mxs.huobi.controller;

import com.mxs.huobi.constant.BaseUriConstant;
import com.mxs.huobi.facade.CandlestickFacade;
import com.mxs.huobi.request.CandlestickRequest;
import com.mxs.huobi.response.CandlestickResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(BaseUriConstant.CANDLESTICK)
public class CandlestickController {
    @Autowired
    private CandlestickFacade candlestickFacade;

    @GetMapping("/custom-list")
    public ResponseEntity<CandlestickResponse> listCandlestick(@Valid CandlestickRequest candlestickRequest) {
        return ResponseEntity.ok(candlestickFacade.listCandlestick(candlestickRequest));
    }
}
