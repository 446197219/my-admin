//package com.yeyu.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.annotation.Resource;
//
//@Configuration
//public class RequestConfig implements WebMvcConfigurer {
//
//    @Resource
//    private RequestUrlInterceptor requestUrlInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加拦截器，配置拦截地址
//        registry.addInterceptor(requestUrlInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/css/**","/js/**","/images/**","/lib/**")//排除样式、脚本、图片等资源文件
//			.excludePathPatterns("/page/login-3.html");
//    }
//}