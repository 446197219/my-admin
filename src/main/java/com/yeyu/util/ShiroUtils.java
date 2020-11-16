package com.yeyu.util;

import com.yeyu.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import java.util.Collection;
import java.util.Objects;

public class ShiroUtils {

	/** 私有构造器 **/
	private ShiroUtils(){ }


    /**
     * 获取当前用户Session
     * @Return SysUserEntity 用户信息
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 用户登出
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

	/**
	 * 获取当前用户信息
	 * @Return SysUserEntity 用户信息
	 */
	public static User getUserInfo() {
		Object principal = SecurityUtils.getSubject().getPrincipal();
		if(principal!=null){
			return (User) principal;
		}else{
			return null;
		}
	}


	/**
	 * 删除用户缓存信息
	 * @Param  username  用户名称
	 * @Param  isRemoveSession 是否删除Session，删除后用户需重新登录
	 */
	public static void deleteCache(){
		//删除Cache，再访问受限接口时会重新授权
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		Authenticator authc = securityManager.getAuthenticator();
//		((LogoutAware) authc).onLogout((SimplePrincipalCollection) attribute);

	}

}