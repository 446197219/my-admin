package com.yeyu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yeyu.common.Page;
import com.yeyu.dao.RoleMapper;
import com.yeyu.dao.ext.MenuExtMapper;
import com.yeyu.dao.ext.RoleExtMapper;
import com.yeyu.dao.ext.RoleMenuExtMapper;
import com.yeyu.pojo.Menu;
import com.yeyu.pojo.Role;
import com.yeyu.service.RoleService;
import com.yeyu.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: my-admin
 * @description:
 * @author: ganzj
 * @create: 2020-11-05 11:28
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;
    @Resource
    RoleExtMapper roleExtMapper;
    @Resource
    MenuExtMapper menuExtMapper;
    @Resource
    RoleMenuExtMapper roleMenuExtMapper;

    @Override
    public Page getAllRolesPage(Role role, Page page) {
        int count = roleExtMapper.getCountAllRoles(role);
        if(count>0){
            page.setDataCount(count);
            PageHelper.startPage(page.getPageNums(),page.getPageSize());
            List<Role> roles = roleExtMapper.getAllRoles(role);
            page.setData(roles);
        }
        return page;
    }

    @Override
    public int deleteRoleByIds(List<Integer> ids) {
        return roleExtMapper.deleteRoleByIds(ids);
    }

    @Override
    public int updateRoleById(Role role) {
        role.setUpdatetime(DateUtil.getCurrentDay(DateUtil.DATE_TIME));
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int saveRole(Role role) {
        role.setCreatetime(DateUtil.getCurrentDay(DateUtil.DATE_TIME));
        return roleMapper.insertSelective(role);
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List getMenuJson() {
        Menu menu = new Menu();
        menu.setIsshow(0);
        List<Menu> menus = menuExtMapper.findMenus(menu);
        List<Menu> collect = menus.stream().filter(item -> item.getPmenuid() == 0).collect(Collectors.toList());
        List<JSONObject> child = collect.stream().map(item -> {
            //判断是否显示
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", item.getName());
            jsonObject.put("id", item.getMenuid());
            jsonObject.put("spread", true);
            jsonObject.put("children", menuToJson(menus,item.getMenuid()));
            return jsonObject;
        }).collect(Collectors.toList());
        return child;
    }

    @Override
    public List findMenuIdsByRoleid(Integer roleId) {
        List<Integer> menuIds = roleMenuExtMapper.findMenuIdsByRoleid(roleId);
        return menuIds;
    }

    @Override
    public int updateMenuRoleAuth(List<Integer> menuIds, Integer roleId) {
        //删除原有权限
        roleMenuExtMapper.deleteByRole(roleId);
        //批量新增权限
        int count = roleMenuExtMapper.saveRoleMenu(menuIds, roleId);
        return count;
    }

    @Override
    public List<Role> getAllRoles(Role role) {
        return roleExtMapper.getAllRoles(role);
    }


    /**
     * 格式化菜单数据
     * @return
     */
    public List<JSONObject> menuToJson(List<Menu> menus,Integer pId) {
        List<JSONObject> collect2 = null;
        //得到子菜单
        List<Menu> collect1 = menus.stream().filter(item1 -> item1.getPmenuid() == pId).collect(Collectors.toList());
        if(collect1.size()>0){
            //格式化子菜单
            collect2 = collect1.stream().map(item2 -> {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", item2.getName());
                jsonObject.put("id", item2.getMenuid());
                jsonObject.put("spread", true);
                jsonObject.put("children", menuToJson(menus,item2.getMenuid()));
                return jsonObject;
            }).collect(Collectors.toList());
        }


        return collect2;
    }
}
