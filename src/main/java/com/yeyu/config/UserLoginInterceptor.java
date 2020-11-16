//package com.yeyu.config;
//
//import com.yeyu.model.ProjectConstants;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * @program: UserLoginInterceptor
// * @description: 拦截器判断用户是否登录
// * @author: ganzj
// * @create:
// */
//@Slf4j
//@Component
//public class UserLoginInterceptor implements HandlerInterceptor {
//
//
//	@Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//    		Object handler)throws Exception {
//
//		String url = request.getServletPath();
//		System.out.println("请求地址："+url);
//		HttpSession session = request.getSession(true);
//		Object username=session.getAttribute(ProjectConstants.SESSION_USER_NAME);
//		if(null!=username) {//已登录
//			return true;
//		}else {//未登录
//			//直接重定向到登录页面
//			response.sendRedirect(request.getContextPath()+"/page/login-3.html");
//			return false;
//		}
//	}
//
//}