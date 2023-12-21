package com.org.system.controller;

import com.org.system.entity.response.CommonResEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class CaptchaController {
    @PostMapping("/captcha")
    public CommonResEntity<?> captcha() {
        return new CommonResEntity<>("success");
    }
}
