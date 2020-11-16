package com.yeyu.dao.ext;

import com.yeyu.pojo.Menu;

import java.util.List;
import java.util.Map;

public interface MenuExtMapper {

    List<Menu> findMenus(Menu menu);

    /**
     * 获得所有父级菜单
     * @return
     */
    List<Map> getParentMenuIdAndName(String isshow);

    List<Menu> getMenusByRoleId(Integer roleId);
}