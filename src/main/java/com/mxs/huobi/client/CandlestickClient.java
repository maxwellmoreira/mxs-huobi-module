package com.mxs.huobi.client;

import com.mxs.huobi.response.CandlestickClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "candlestick", url = "${huobi.url}")
public interface CandlestickClient {
    @GetMapping("/market/history/kline")
    CandlestickClientResponse getLastPattern(@RequestParam("symbol") String symbol,
                                             @RequestParam("period") String period,
                                             @RequestParam("size") int size);
}
