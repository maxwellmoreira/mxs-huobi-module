package com.mxs.huobi.factory;

import com.mxs.huobi.contract.PeriodContract;
import com.mxs.huobi.exception.BadRequestException;
import com.mxs.huobi.strategy.PeriodSixtyMinutesStrategy;
import com.mxs.huobi.type.PeriodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeriodFactory {
    @Autowired
    private PeriodSixtyMinutesStrategy periodSixtyMinutesStrategy;

    public PeriodContract setPeriod(PeriodType periodType) {
        if (PeriodType.SIXTY_MINUTES.getCode().equalsIgnoreCase(periodType.getCode())) {
            return periodSixtyMinutesStrategy;
        } else {
            throw new BadRequestException("Invalid operating period or not mapped");
        }
    }
}
