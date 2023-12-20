package com.org.exception.entity;

import com.org.exception.function.ExceptionHandle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(value = HttpStatus.OK)
public class CustomException extends RuntimeException {

    private String message;
    // 可以添加更多自定义的属性和方法
    private int code;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public CustomException(String message, ExceptionHandle exceptionHandle) {
        super(message);
        exceptionHandle.run();
    }
}
