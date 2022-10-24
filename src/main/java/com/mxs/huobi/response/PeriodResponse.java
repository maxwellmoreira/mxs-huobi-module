package com.mxs.huobi.response;

import com.mxs.huobi.dto.PeriodDto;
import com.mxs.huobi.type.PeriodType;

import java.util.List;

public class PeriodResponse {
    private PeriodType periodType;
    private List<PeriodDto> periodDtoList;

    public PeriodType getPeriodType() {
        return periodType;
    }

    public List<PeriodDto> getPeriodDtoList() {
        return periodDtoList;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public void setPeriodDtoList(List<PeriodDto> periodDtoList) {
        this.periodDtoList = periodDtoList;
    }
}
