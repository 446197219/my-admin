package com.yeyu.config;

import com.yeyu.dao.ext.UserExtMapper;
import com.yeyu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: my-admin
 * @description: 自定义Realm
 * @author: ganzj
 * @create: 2020-11-03 14:27
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    UserExtMapper userExtMapper;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权逻辑");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取用户
        User user = (User) principalCollection.getPrimaryPrincipal();
        log.info("授权用户："+user.toString());
//        info.addStringPermission("user:add");
        simpleAuthorizationInfo.addRoles(Arrays.asList(user.getRoleId().toString().split(",")));
        return simpleAuthorizationInfo;

    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行认证逻辑");

        String username = (String) authenticationToken.getPrincipal();
        User user = userExtMapper.login(username);
        if(null==user){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
