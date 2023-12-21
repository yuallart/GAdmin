package com.org.system.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResData<T> {
    private String msg = "";
    private int code = 0;
    private T data;

    public ResData(T data) {
        this.data = data;
    }

    public ResData(String msg) {
        this.msg = msg;
        this.data = null;
    }

    public ResData(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public ResData(String msg, T data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }
}
