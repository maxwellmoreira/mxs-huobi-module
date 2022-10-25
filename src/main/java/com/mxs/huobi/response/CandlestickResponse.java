package com.mxs.huobi.response;

import com.mxs.huobi.dto.CandlestickDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandlestickResponse {
    private String ch;
    private String status;
    private BigDecimal ts;
    private List<CandlestickDto> candlestickDtoList;
}
