package com.mxs.huobi.converter;

import com.mxs.huobi.dto.CandlestickClientDto;
import com.mxs.huobi.dto.CandlestickDto;
import com.mxs.huobi.response.CandlestickClientResponse;
import com.mxs.huobi.response.CandlestickResponse;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class CandlestickConverter {
    public CandlestickResponse convertToCandlestickResponse(CandlestickClientResponse candlestickClientResponse) {
        CandlestickResponse candlestickResponse = new CandlestickResponse();
        candlestickResponse.setCh(candlestickClientResponse.getCh());
        candlestickResponse.setStatus(candlestickClientResponse.getStatus());
        candlestickResponse.setTs(candlestickClientResponse.getTs());
        candlestickResponse.setCandlestickDtoList(
                candlestickClientResponse.getData().stream().map(
                        this::buildCandlestickDto).collect(Collectors.toList()));
        return candlestickResponse;
    }

    private CandlestickDto buildCandlestickDto(CandlestickClientDto candlestickClientDto) {
        CandlestickDto candlestickDto = new CandlestickDto();
        candlestickDto.setId(candlestickClientDto.getId());
        candlestickDto.setOpen(candlestickClientDto.getOpen());
        candlestickDto.setClose(candlestickClientDto.getClose());
        candlestickDto.setHigh(candlestickClientDto.getHigh());
        candlestickDto.setLow(candlestickClientDto.getLow());
        candlestickDto.setAmount(candlestickClientDto.getAmount());
        candlestickDto.setVol(candlestickClientDto.getVol());
        candlestickDto.setCount(candlestickDto.getCount());
        return candlestickDto;
    }
}
