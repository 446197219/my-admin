//package com.yeyu.config;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.yeyu.dao.RequestLogMapper;
//import com.yeyu.pojo.RequestLog;
//import com.yeyu.pojo.User;
//import com.yeyu.util.DateUtil;
//import com.yeyu.util.ShiroUtils;
//import com.yeyu.util.SpringUtil;
//import com.yeyu.util.SysUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 自定义拦截器，拦截请求路径
// */
//@Slf4j
//@Component
//public class RequestUrlInterceptor implements HandlerInterceptor {
//
//    //请求开始时间标识
//    private static final String LOGGER_SEND_TIME = "_send_time";
//    //请求日志实体标识
//    private static final String LOGGER_ENTITY = "_logger_entity";
//
//    @Override
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //创建日志实体
//        RequestLog sysLog = new RequestLog();
//
//        //获取请求参数信息
//        String param = JSON.toJSONString(request.getParameterMap(),
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteMapNullValue);
//        //设置请求参数
//        sysLog.setParams(param);
//
//        //得到用户信息
//        User user = ShiroUtils.getUserInfo();
//        if(user!=null){
//            sysLog.setUserid(user.getUserid());
//            sysLog.setUsername(user.getUsername());
//        }
//        // 设置IP地址
//        sysLog.setIp(SysUtil.getIpAddress(request));
//
//        //设置请求方法,GET,POST...
//        sysLog.setMethod(request.getMethod());
//
//        //设置请求路径
//        sysLog.setUri(request.getRequestURI());
//        //请求时间
//        sysLog.setTime(DateUtil.getCurrentDay(DateUtil.DATE_TIME));
//        //设置请求开始时间
//        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
//
//        //设置请求实体到request内，方便afterCompletion方法调用
//        request.setAttribute(LOGGER_ENTITY,sysLog);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        int status = response.getStatus();
//        //根据不同状态码，跳转不同页面，如
//        if(status==404){
//            modelAndView.setViewName("/page/404.html");
//        }
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        //得到bean
//        RequestLogMapper requestLogMapper = SpringUtil.getBean(RequestLogMapper.class);
//
//        //获取请求错误码，根据需求存入数据库，这里不保存
////        int status = response.getStatus();
//
//        //获取本次请求日志实体
//        RequestLog sysLog = (RequestLog) request.getAttribute(LOGGER_ENTITY);
//
//        //设置访问者
//        sysLog.setUsername("admin");
//        //执行将日志写入数据库，可以根据实际需求进行保存
////        if(!sysLog.getMethod().equals("GET")){
////        }
//        requestLogMapper.insertSelective(sysLog);
//    }
//}