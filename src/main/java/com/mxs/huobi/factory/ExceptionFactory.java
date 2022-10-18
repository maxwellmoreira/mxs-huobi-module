package com.mxs.huobi.factory;

import com.mxs.huobi.dto.ExceptionDto;
import com.mxs.huobi.exception.BadRequestException;
import com.mxs.huobi.type.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionFactory {
    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionDto resourceBadRequestException(BadRequestException badRequestException) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setType(ExceptionType.BUSINESS);
        exceptionDto.getMessage(badRequestException.getMessage());
        return exceptionDto;
    }
}
