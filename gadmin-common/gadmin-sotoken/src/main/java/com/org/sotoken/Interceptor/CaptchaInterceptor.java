package com.org.sotoken.Interceptor;

import cn.dev33.satoken.interceptor.SaInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CaptchaInterceptor extends SaInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String header = request.getHeader("Content-Type");
        if(method.equals("get")){

        }
        return super.preHandle(request, response, handler);
    }

    public Map<String,String> parseRequestJson(HttpServletRequest request) {
        HashMap<String,String> map=new HashMap<>();
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                builder.append(inputStr);
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("解析json出错");
        }
        return map;
    }
}
