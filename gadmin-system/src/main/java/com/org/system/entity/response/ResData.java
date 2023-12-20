package com.org.system.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResData<T> {
    private String msg;
    private Timestamp time;
    private T data;

    public ResData(String msg, T data) {
        this.msg = msg;
        this.time = DateUtil.currentTimestamp();
        this.data = data;
    }
}
