package com.yeyu.dao.ext;


import com.yeyu.pojo.Role;

import java.util.List;

public interface RequestLogExtMapper {

    int getCountRequestLogPage(Role role);

    List<Role> getAllRequestLogPage(Role role);
}