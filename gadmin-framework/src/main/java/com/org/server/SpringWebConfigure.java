package com.org.server;

import com.org.sotoken.Interceptor.CaptchaInterceptor;
import com.org.sotoken.Interceptor.CheckLoginInterceptor;
import com.org.sotoken.entity.ExcludePath;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebConfigure implements WebMvcConfigurer {
    @Resource
    private ExcludePath excludePath;

    @Bean
    public CaptchaInterceptor captchaInterceptor() {
        return new CaptchaInterceptor();
    }

    @Bean
    public CheckLoginInterceptor checkLoginInterceptor() {
        return new CheckLoginInterceptor();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*全局触发的登录拦截器*/
        registry.addInterceptor(checkLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath.getExclude());
        /*只在登录时触发的机器人验证码拦截器*/
        registry.addInterceptor(captchaInterceptor())
                .addPathPatterns("/login");
    }
}

