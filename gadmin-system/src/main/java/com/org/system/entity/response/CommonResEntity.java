package com.org.system.entity.response;

import cn.hutool.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

/**
 * @author: Yuallart
 * @version: 1.0.0
 * @since: 1.0.0
 * @date: 2023-12-20
 * @description: 通用返回类
 */
@Getter
@Setter
public class CommonResEntity<T> extends ResponseEntity<ResData<T>> {

    public CommonResEntity(ResData<T> resData) {
        super(resData, HttpStatusCode.valueOf(HttpStatus.HTTP_OK));
    }

    public CommonResEntity(String msg) {
        super(new ResData<>(msg), HttpStatusCode.valueOf(HttpStatus.HTTP_OK));
    }

    public CommonResEntity(T data) {
        super(new ResData<>(data), HttpStatusCode.valueOf(HttpStatus.HTTP_OK));
        HttpHeaders headers = this.getHeaders();
    }

    public CommonResEntity(String msg, T data) {
        super(new ResData<>(msg, data), HttpStatusCode.valueOf(HttpStatus.HTTP_OK));
        HttpHeaders headers = this.getHeaders();
    }

    public CommonResEntity(String msg, T data, int code) {
        super(new ResData<>(msg, data, code), HttpStatusCode.valueOf(HttpStatus.HTTP_OK));
    }

    public CommonResEntity<T> setHeader(CommonResRun commonResRun) {
        commonResRun.run(this.getHeaders());
        return this;
    }

}
