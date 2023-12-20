package com.org.exception.controller;

import com.org.exception.entity.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        //创建响应体，提供更多有关错误的详细信息
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());
        responseBody.put("status", HttpStatus.BAD_REQUEST.value());
        // 可以添加更多自定义的响应信息
        //返回ResponseEntity对象
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

}
