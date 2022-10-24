package com.mxs.huobi.strategy;

import com.mxs.huobi.contract.PeriodContract;
import com.mxs.huobi.converter.PeriodConverter;
import com.mxs.huobi.dto.CandlestickDto;
import com.mxs.huobi.dto.PeriodDto;
import com.mxs.huobi.request.CandlestickRequest;
import com.mxs.huobi.request.PeriodRequest;
import com.mxs.huobi.response.CandlestickResponse;
import com.mxs.huobi.response.PeriodResponse;
import com.mxs.huobi.type.PeriodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public PeriodResponse buildPeriodResponse(CandlestickResponse candlestickResponse) {

        PeriodResponse periodResponse = new PeriodResponse();
        periodResponse.setPeriodType(PeriodType.SIXTY_MINUTES);

        List<PeriodNestedClass> periodNestedClassList = new ArrayList<>();
        PeriodSixtyMinutesStrategy.PeriodNestedClass periodNestedClass = new PeriodNestedClass();
        periodNestedClassList.add(periodNestedClass);

        periodResponse.setPeriodDtoList(candlestickResponse.getCandlestickDtoList().stream().map(
                candlestickDto -> {

                    PeriodSixtyMinutesStrategy.PeriodNestedClass periodStopedFalse =
                            periodNestedClassList.stream().filter(period -> !period.stoped).findFirst().orElse(null);

                    if (periodStopedFalse.getHour() < MIDNIGHT) {

                        periodStopedFalse.setStoped(true);

                        PeriodSixtyMinutesStrategy.PeriodNestedClass newPeriodNestedClass = new PeriodNestedClass();
                        newPeriodNestedClass.setLocalDateTime(periodStopedFalse.getLocalDateTime().minusDays(LESS_ONE_DAY));
                        newPeriodNestedClass.setHour(TWENTY_THREE_HOURS);

                        periodNestedClassList.add(newPeriodNestedClass);

                        return buildPeriodDto(candlestickDto, newPeriodNestedClass);
                    } else {
                        return buildPeriodDto(candlestickDto, periodStopedFalse);
                    }
                }).collect(Collectors.toList()));
        return periodResponse;
    }

    public PeriodDto buildPeriodDto(CandlestickDto candlestickDto, PeriodNestedClass periodNestedClass) {
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

    private static class PeriodNestedClass {
        private LocalDateTime localDateTime;
        private int hour;
        private boolean stoped;

        public PeriodNestedClass() {
            ZoneId zoneId = ZoneId.of("GMT+8");
            this.localDateTime = LocalDateTime.now(zoneId);
            this.hour = localDateTime.getHour();
            this.stoped = false;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public int getHour() {
            return hour;
        }

        public boolean isStoped() {
            return stoped;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public void setStoped(boolean stoped) {
            this.stoped = stoped;
        }
    }
}
