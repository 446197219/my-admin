package com.yeyu.service;

import com.yeyu.pojo.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * 获得菜单json数据 返回页面显示
     * @return
     */
    List getMenuJson(Menu menu);

    /**
     * 查询所有菜单信息
     * @return
     */
    List findMenus();

    /**
     * 根据ID查询菜单信息
     * @param menuid
     * @return
     */
    Menu getMenuById(Integer menuid);

    List<Map> getParentMenuIdAndName();

    int updateMenu(Menu menu);

    int deleteMenuById(Integer menuid);

    int addMenu(Menu menu);

    List getMenuJsonSelect(Menu menu);
}
