package com.mxs.huobi.request;

import com.mxs.huobi.type.CurrencyPairType;
import com.mxs.huobi.type.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodRequest {
    @NotNull(message = "Symbol is null")
    private CurrencyPairType symbol;
    @NotNull(message = "Period is null")
    private PeriodType period;
    @Min(value = 1, message = "Size should not be less than 1")
    private int size;
}
