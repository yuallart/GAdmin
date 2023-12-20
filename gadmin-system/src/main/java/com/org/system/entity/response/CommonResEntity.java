package com.org.system.entity.response;

import cn.hutool.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * @author: Yuallart
 * @version: 1.0.0
 * @since: 1.0.0
 * @date: 2023-12-20
 * @description:
 */
@Getter
@Setter
public class CommonResEntity<T> extends ResponseEntity<ResData<T>> {

    private ResData<T> resData;

    public CommonResEntity(ResData<T> resData) {
        super(resData, HttpStatusCode.valueOf(HttpStatus.HTTP_OK));
        String dateNow = String.valueOf(new Date().getTime());
    }

}
