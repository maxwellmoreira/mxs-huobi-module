package com.mxs.huobi.dto;

import com.mxs.huobi.constant.DateFormatConstant;
import com.mxs.huobi.type.ExceptionType;

import java.sql.Timestamp;

public class ExceptionDto {
    private ExceptionType type;
    private String message;
    private String timestamp;

    public ExceptionDto() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.timestamp = DateFormatConstant.FORMAT_FOR_EXCEPTION.format(now);
    }

    public ExceptionType getType() {
        return type;
    }

    public String getMessage(String message) {
        return this.message;
    }

    public void setType(ExceptionType type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
