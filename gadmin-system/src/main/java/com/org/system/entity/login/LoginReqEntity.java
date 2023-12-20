package com.org.system.entity.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqEntity {
    @NotBlank
    private String loginType;
    @NotBlank
    private String captchaType;
    @NotNull
    private Object login;
    @NotNull
    private Object captcha;
}
