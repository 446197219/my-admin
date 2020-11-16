package com.yeyu.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yeyu.common.R;
import com.yeyu.dao.RequestLogMapper;
import com.yeyu.pojo.RequestLog;
import com.yeyu.pojo.User;
import com.yeyu.util.DateUtil;
import com.yeyu.util.ShiroUtils;
import com.yeyu.util.SpringUtil;
import com.yeyu.util.SysUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: my-admin
 * @description: 自定义角色权限校验
 * @author: ganzj
 * @create: 2020-11-05 11:00
 */
@Slf4j
public class MyRolesAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws IOException {
        Subject subject = getSubject(req, resp);
        String[] rolesArray = (String[]) mappedValue;
        saveRequestLog(req);
        // 没有角色限制，有权限访问
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }
        for (int i = 0; i < rolesArray.length; i++) {
            //若当前用户是rolesArray中的任何一个，则有权限访问
            if (subject.hasRole(rolesArray[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse resp) throws IOException {
        if (isAjax(req)) {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().write(JSONObject.toJSONString(R.error(403, "权限不足!!!")));
            resp.getWriter().flush();
            resp.getWriter().close();
        }else{
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/page/noAuth.html");
        }
        return Boolean.FALSE;
    }

    private boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void saveRequestLog(ServletRequest req){
        HttpServletRequest request = (HttpServletRequest) req;
        //创建日志实体
        RequestLog sysLog = new RequestLog();

        //获取请求参数信息
        String param = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置请求参数
        sysLog.setParams(param);

        //得到用户信息
        User user = ShiroUtils.getUserInfo();
        if(user!=null){
            sysLog.setUserid(user.getUserid());
            sysLog.setUsername(user.getUsername());
        }
        // 设置IP地址
        sysLog.setIp(SysUtil.getIpAddress(request));

        //设置请求方法,GET,POST...
        sysLog.setMethod(request.getMethod());

        //设置请求路径
        sysLog.setUri(request.getRequestURI());
        //请求时间
        sysLog.setTime(DateUtil.getCurrentDay(DateUtil.DATE_TIME));
        //得到bean
        RequestLogMapper requestLogMapper = SpringUtil.getBean(RequestLogMapper.class);
        requestLogMapper.insertSelective(sysLog);
    }
}
