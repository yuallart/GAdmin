package com.org.exception.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class CommonException extends RuntimeException {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object body;

    public CommonException(CommonExceptionHandle commonExceptionHandle) {

    }
}
