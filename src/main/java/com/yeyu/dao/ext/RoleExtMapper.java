package com.yeyu.dao.ext;


import com.yeyu.pojo.Role;

import java.util.List;

public interface RoleExtMapper {

    int getCountAllRoles(Role role);

    List<Role> getAllRoles(Role role);

    int deleteRoleByIds(List ids);
}