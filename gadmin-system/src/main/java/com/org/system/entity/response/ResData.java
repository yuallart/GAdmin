package com.org.system.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResData<T> {
    private String msg;
    private int code;
    private T data;

    public ResData(String msg, T data) {
        this.code = 0;
        this.msg = msg;
        this.data = data;
    }
}
