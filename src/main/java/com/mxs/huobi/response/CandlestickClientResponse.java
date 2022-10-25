package com.mxs.huobi.response;

import com.mxs.huobi.dto.CandlestickClientDto;
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
public class CandlestickClientResponse {
    private String ch;
    private String status;
    private BigDecimal ts;
    private List<CandlestickClientDto> data;
}
