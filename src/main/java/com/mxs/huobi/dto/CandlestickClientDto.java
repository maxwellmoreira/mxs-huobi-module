package com.mxs.huobi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandlestickClientDto {
    private BigDecimal id; // The UNIX timestamp in seconds as response id
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal amount; // Accumulated trading volume, in base currency
    private BigDecimal vol; // Accumulated trading value, in quote currency
    private BigDecimal count; // The number of completed trades
}
