package com.mxs.huobi.dto;

import com.mxs.huobi.constant.DateFormatConstant;
import com.mxs.huobi.type.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
public class ExceptionDto {
    private ExceptionType type;
    private String message;
    private String timestamp;

    public ExceptionDto() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.timestamp = DateFormatConstant.FORMAT_FOR_EXCEPTION.format(now);
    }
}
