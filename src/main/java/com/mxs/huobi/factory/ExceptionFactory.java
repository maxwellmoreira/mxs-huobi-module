package com.mxs.huobi.factory;

import com.mxs.huobi.dto.ExceptionDto;
import com.mxs.huobi.exception.BadRequestException;
import com.mxs.huobi.type.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionFactory {
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ExceptionDto> resourceBadRequestException(BadRequestException badRequestException, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setType(ExceptionType.BUSINESS);
        exceptionDto.setMessage(badRequestException.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<ExceptionDto> resourceIllegalStateException(IllegalStateException illegalStateException, WebRequest webRequest) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setType(ExceptionType.BUSINESS);
        exceptionDto.setMessage(illegalStateException.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
