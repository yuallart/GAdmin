package com.org.exception.controller;

import com.org.exception.mapper.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public ResponseEntity<Object> handleCustomException(CommonException commonException) {
        return ResponseEntity.ok(commonException.body);
    }

}
