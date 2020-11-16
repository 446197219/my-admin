package com.yeyu.service;

import com.yeyu.common.Page;
import com.yeyu.pojo.Role;

import java.util.List;

/**
 * @program: my-admin
 * @description: 系统角色业务类
 * @author: ganzj
 * @create: 2020-11-05 11:24
 */
public interface RoleService {

    /**
     * 查询所有角色
     * @param status 取消参数* 状态 1:有效 2:删除   null：查询所有
     * @param role
     * @return
     */
    Page getAllRolesPage(Role role,Page page);

    /**
     * 根据id删除角色（单个或批量）  觉得角色不太需要逻辑删除 所以写为物理删除
     * @param ids
     * @return
     */
    int deleteRoleByIds(List<Integer> ids);

    /**
     * 根据id修改角色
     * @param role 角色信息
     * @return
     */
    int updateRoleById(Role role);

    /**
     * 新增角色
     * @param role
     * @return
     */
    int saveRole(Role role);

    /**
     * 根据ID查找角色信息
     * @param id
     * @return
     */
    Role getRoleById(Integer id);

    /**
     * 格式化菜单权限数据 用于显示绑定权限
     * @return
     */
    List getMenuJson();

    /**
     * 查询角色已有权限
     * @return
     */
    List findMenuIdsByRoleid(Integer roleId);

    int updateMenuRoleAuth(List<Integer> menuIds, Integer roleId);

    List<Role> getAllRoles(Role role);

}
