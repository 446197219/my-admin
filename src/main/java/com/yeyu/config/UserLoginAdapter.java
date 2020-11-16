//package com.yeyu.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
///**
// * @program: UserLoginInterceptor
// * @description: 拦截器判断用户是否登录
// * @author: ganzj
// * @create:
// */
//@SpringBootApplication
//@EnableCaching
//public class UserLoginAdapter implements WebMvcConfigurer{
//
//	@Autowired
//	private UserLoginInterceptor userLoginInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//
//		//添加对用户是否登录的拦截器，并添加过滤项、排除项
//		registry.addInterceptor(userLoginInterceptor).addPathPatterns("/**")
//			.excludePathPatterns("/css/**","/js/**","/images/**","/lib/**")//排除样式、脚本、图片等资源文件
//			.excludePathPatterns("/wx/**/**")
//			.excludePathPatterns("/page/login-3.html")//排除登录页面
//			.excludePathPatterns("/user/userLogin")//排除验证码
//			.excludePathPatterns("/wechatplatformuser/loginRBAC");//排除
//		// 用户点击登录按钮
//
//	}
//
//}