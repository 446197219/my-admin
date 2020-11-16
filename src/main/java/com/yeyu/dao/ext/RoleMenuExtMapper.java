package com.yeyu.dao.ext;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMenuExtMapper {

    int deleteByRole(Integer roleId);

    int saveRoleMenu(@Param("menuIds") List<Integer> menuIds, @Param("roleId") Integer roleId);

    List<Integer> findMenuIdsByRoleid(Integer roleId);

    /**
     * 查询角色所绑定的权限 用于授权
     * @return
     */
    List<Map> getMenuUrlAndRoleId();
}