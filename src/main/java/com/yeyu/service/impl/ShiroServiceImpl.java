package com.yeyu.service.impl;

import com.yeyu.config.MyException;
import com.yeyu.dao.MenuMapper;
import com.yeyu.dao.RoleMapper;
import com.yeyu.dao.UserMapper;
import com.yeyu.dao.ext.MenuExtMapper;
import com.yeyu.dao.ext.RoleMenuExtMapper;
import com.yeyu.pojo.Menu;
import com.yeyu.pojo.Role;
import com.yeyu.pojo.User;
import com.yeyu.service.ShiroService;
import com.yeyu.util.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Slf4j
@Service
public class ShiroServiceImpl implements ShiroService {
    @Resource
    private RoleMenuExtMapper roleMenuExtMapper;

    @Override
    public Map<String, String> loadFilterChainDefinitionMap() {
        // 权限控制map
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置过滤:不会被拦截的链接 -> 放行 start ----------------------------------------------------------
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/lib/**","anon");
        filterChainDefinitionMap.put("/user/userLogin","anon");
        //登出
        filterChainDefinitionMap.put("/user/logout", "logout");

        List<Map> permissionList = roleMenuExtMapper.getMenuUrlAndRoleId();
        if ( !CollectionUtils.isEmpty( permissionList ) ) {
            permissionList.forEach( e -> {
                StringJoiner zqRoles = new StringJoiner(",", "zqRoles[", "]");
                // 根据url查询相关联的角色名,拼接自定义的角色权限
                zqRoles.add( (e.get("roleId") == null || StringUtils.isEmpty(e.get("roleId").toString()))?"00":e.get("roleId").toString() );

                    // 注意过滤器配置顺序不能颠倒
                    // ① 认证登录
                    // ② 认证自定义的token过滤器 - 判断token是否有效
                    // ③ 角色权限 zqRoles：自定义的只需要满足其中一个角色即可访问  ;  roles[admin,guest] : 默认需要每个参数满足才算通过，相当于hasAllRoles()方法
                    // ④ zqPerms:认证自定义的url过滤器拦截权限  【注：多个过滤器用 , 分割】
                filterChainDefinitionMap.put( e.get("menuUrl").toString().substring(0,1).equals("/")?e.get("menuUrl").toString():"/"+e.get("menuUrl").toString(),zqRoles.toString() );
            });
        }
        System.out.println(filterChainDefinitionMap.toString());
        // ⑤ 认证登录  【注：map不能存放相同key】
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }

    @Override
    public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean) throws MyException {
        synchronized (shiroFilterFactoryBean) {
            AbstractShiroFilter shiroFilter = null;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
                PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
                DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
                // 1. 清空老的权限控制
                manager.getFilterChains().clear();
                shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();

                // ========== 2. 动态加载权限核心部分开始 ==========
                // 后面这个可以直接从数据库里面获取

                //循环url,逐个添加到section中。section就是filterChainDefinitionMap,
                //里面的键就是链接URL,值就是存在什么条件才能访问该链接(正式环境从数据库获取,这里模拟数据权限切换)
                shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitionMap());
                // ========== 2. 动态加载权限核心部分结束 ==========

                // 3. 重新构建生成
                Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
                for (Map.Entry<String, String> entry : chains.entrySet()) {
                    String url = entry.getKey();
                    String chainDefinition = entry.getValue().trim().replace(" ", "");
                    manager.createChain(url, chainDefinition);
                }
                System.out.println("更新权限成功");
            } catch (Exception e) {
                throw new RuntimeException("更新shiro权限出现错误!");
            }
        }
            log.info("--------------- 动态生成url权限成功！ ---------------");
    }

    @Override
    public void updatePermissionByRoleId(Integer roleId, Boolean isRemoveSession) {
//        // 查询当前角色的用户shiro缓存信息 -> 实现动态权限
//        List<User> userList = userMapper.selectUserByRoleId(roleId);
//        // 删除当前角色关联的用户缓存信息,用户再次访问接口时会重新授权 ; isRemoveSession为true时删除Session -> 即强制用户退出
//        if ( !CollectionUtils.isEmpty( userList ) ) {
//            for (User user : userList) {
//                ShiroUtils.deleteCache(user.getUsername(), isRemoveSession);
//            }
//        }
        log.info("--------------- 动态修改用户权限成功！ ---------------");
    }
}