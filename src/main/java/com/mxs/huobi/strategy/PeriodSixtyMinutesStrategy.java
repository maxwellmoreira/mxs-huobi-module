package com.mxs.huobi.strategy;

import com.mxs.huobi.contract.PeriodContract;
import com.mxs.huobi.converter.PeriodConverter;
import com.mxs.huobi.dto.CandlestickDto;
import com.mxs.huobi.dto.PeriodDto;
import com.mxs.huobi.request.CandlestickRequest;
import com.mxs.huobi.request.PeriodRequest;
import com.mxs.huobi.response.CandlestickResponse;
import com.mxs.huobi.response.PeriodResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mxs.huobi.type.PeriodType.SIXTY_MINUTES;

@Service
public class PeriodSixtyMinutesStrategy implements PeriodContract {
    private static final int LESS_ONE_DAY = 1;
    private static final int LESS_ONE_HOUR = 1;
    private static final int MIDNIGHT = 0;
    private static final int TWENTY_THREE_HOURS = 23;

    @Autowired
    private CandlestickStrategy candlestickStrategy;
    @Autowired
    private PeriodConverter periodConverter;

    @Override
    public PeriodResponse listCandlestickByPeriod(PeriodRequest periodRequest) {
        CandlestickRequest candlestickRequest = periodConverter.convertToCandlestickRequest(periodRequest);
        CandlestickResponse candlestickResponse = candlestickStrategy.listCandlestick(candlestickRequest);
        return buildPeriodResponse(candlestickResponse);
    }

    private PeriodResponse buildPeriodResponse(CandlestickResponse candlestickResponse) {

        PeriodResponse periodResponse = new PeriodResponse();
        periodResponse.setPeriodType(SIXTY_MINUTES);

        List<OperatingPeriod> operatingPeriodList = new ArrayList<>();
        PeriodSixtyMinutesStrategy.OperatingPeriod operatingPeriod = new OperatingPeriod();
        operatingPeriodList.add(operatingPeriod);

        periodResponse.setPeriodDtoList(candlestickResponse.getCandlestickDtoList().stream().map(
                candlestickDto -> {

                    PeriodSixtyMinutesStrategy.OperatingPeriod trueOperatingPeriod =
                            operatingPeriodList.stream().filter(
                                    period -> !period.stoped).findFirst().orElse(null);

                    if (trueOperatingPeriod == null) {
                        throw new IllegalStateException("There was an error getting a valid operating period");
                    }

                    if (trueOperatingPeriod.getHour() < MIDNIGHT) {

                        trueOperatingPeriod.setStoped(Boolean.TRUE);

                        PeriodSixtyMinutesStrategy.OperatingPeriod newOperatingPeriod = new OperatingPeriod();
                        newOperatingPeriod.setLocalDateTime(trueOperatingPeriod.getLocalDateTime().minusDays(LESS_ONE_DAY));
                        newOperatingPeriod.setHour(TWENTY_THREE_HOURS);

                        operatingPeriodList.add(newOperatingPeriod);

                        return buildPeriodDto(candlestickDto, newOperatingPeriod);
                    } else {
                        return buildPeriodDto(candlestickDto, trueOperatingPeriod);
                    }
                }).collect(Collectors.toList()));
        return periodResponse;
    }

    private PeriodDto buildPeriodDto(CandlestickDto candlestickDto, OperatingPeriod periodNestedClass) {
        PeriodDto periodDto = new PeriodDto();

        periodDto.setOpen(candlestickDto.getOpen());
        periodDto.setClose(candlestickDto.getClose());
        periodDto.setHigh(candlestickDto.getHigh());
        periodDto.setLow(candlestickDto.getLow());

        periodDto.setDayOfYear(periodNestedClass.getLocalDateTime().getDayOfYear());
        periodDto.setDayOfMonth(periodNestedClass.getLocalDateTime().getDayOfMonth());
        periodDto.setDayOfWeek(periodNestedClass.getLocalDateTime().getDayOfWeek().name());

        periodDto.setYear(periodNestedClass.getLocalDateTime().getYear());
        periodDto.setMonth(periodNestedClass.getLocalDateTime().getMonth().name());
        periodDto.setHour(periodNestedClass.getHour());

        periodNestedClass.setHour(periodNestedClass.getHour() - LESS_ONE_HOUR);

        return periodDto;
    }

    @Data
    @Builder
    @AllArgsConstructor
    private static class OperatingPeriod {
        private LocalDateTime localDateTime;
        private int hour;
        private boolean stoped;

        public OperatingPeriod() {
            ZoneId zoneId = ZoneId.of("GMT+8");
            this.localDateTime = LocalDateTime.now(zoneId);
            this.hour = localDateTime.getHour();
            this.stoped = Boolean.FALSE;
        }
    }
}
