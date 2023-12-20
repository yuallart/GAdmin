package com.org.sotoken.Interceptor;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor extends SaInterceptor {
    /**
     * 检查有没有登录
     */
    public CheckLoginInterceptor() {
        this.setAuth(handle -> {
            StpUtil.checkLogin();
        });
    }
}
