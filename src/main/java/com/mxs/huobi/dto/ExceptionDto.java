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

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setType(ExceptionType type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
