package com.yeyu.controller;

import com.github.pagehelper.PageHelper;
import com.yeyu.common.Page;
import com.yeyu.common.R;
import com.yeyu.config.MyException;
import com.yeyu.pojo.Role;
import com.yeyu.service.RoleService;
import com.yeyu.service.ShiroService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: my-admin
 * @description: 系统角色控制类
 * @author: ganzj
 * @create: 2020-11-05 14:06
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    ShiroService shiroService;
    @Autowired
    ShiroFilterFactoryBean shiroFilterFactoryBean;

    /**
     * 分页查询所有角色信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllRolesPage")
    public R getAllRolesPage(Role role,Page page){
        roleService.getAllRolesPage(role,page);
        return R.ok().put("page",page);
    }

    @ResponseBody
    @RequestMapping("deleteRoleByIds")
    public R deleteRoleByIds(@RequestParam(value = "ids[]") List<Integer> ids){
        int count = roleService.deleteRoleByIds(ids);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("删除失败，无对应数据");
        }
    }

    @ResponseBody
    @RequestMapping("updateRoleById")
    public R updateRoleById(Role role){
        int count = roleService.updateRoleById(role);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("删除失败");
        }
    }

    @ResponseBody
    @RequestMapping("saveRole")
    public R saveRole(Role role){
        int count = roleService.saveRole(role);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("新增失败");
        }
    }

    @ResponseBody
    @RequestMapping("getRoleById")
    public R getRoleById(Integer id){
        Role role = roleService.getRoleById(id);
        return R.ok().put("data",role);
    }

    @ResponseBody
    @RequestMapping("getMenuRoleById")
    public R getMenuRoleById(Integer roleId){
        List menuJson = roleService.getMenuJson();
        List menuIds = roleService.findMenuIdsByRoleid(roleId);
        return R.ok().put("menuJson",menuJson).put("bindData",menuIds);
    }

    @ResponseBody
    @RequestMapping("updateMenuRoleAuth")
    public R updateMenuRoleAuth(@RequestParam(value = "menuIds[]") List<Integer> menuIds,@RequestParam(value = "roleId")Integer roleId) throws MyException {
        int count = roleService.updateMenuRoleAuth(menuIds,roleId);
        //修改角色权限需要刷新shiro缓存权限
        shiroService.updatePermission(shiroFilterFactoryBean);
        return R.ok();
    }

    /**
     * 分页查询所有角色信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllRoles")
    public R getAllRoles(Role role){
        List<Role> roles = roleService.getAllRoles(role);
        return R.ok().put("roles",roles);
    }
}
