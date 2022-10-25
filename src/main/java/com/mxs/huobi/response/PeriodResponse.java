package com.mxs.huobi.response;

import com.mxs.huobi.dto.PeriodDto;
import com.mxs.huobi.type.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodResponse {
    private PeriodType periodType;
    private List<PeriodDto> periodDtoList;
}
