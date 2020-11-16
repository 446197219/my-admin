package com.yeyu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yeyu.dao.MenuMapper;
import com.yeyu.dao.ext.MenuExtMapper;
import com.yeyu.pojo.Menu;
import com.yeyu.pojo.User;
import com.yeyu.service.MenuService;
import com.yeyu.util.ShiroUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 菜单业务类
 * @author: ganzj
 * @create: 2020-09-21 11:25
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Resource
    MenuExtMapper menuExtMapper;

    @Override
    public List getMenuJson(Menu menu) {
        menu.setIsshow(0);
        menu.setNodetype("1");
        User user = ShiroUtils.getUserInfo();
        List<Menu> menus = menuExtMapper.getMenusByRoleId(user.getRoleId());
        List<Menu> collect = menus.stream().filter(item -> item.getPmenuid() == 0).collect(Collectors.toList());
        List<JSONObject> child = collect.stream().map(item -> {
            //判断是否显示
            JSONObject jsonObject = menuToJson(item);

            //得到子菜单
            List<Menu> collect1 = menus.stream().filter(item1 -> item1.getPmenuid() == item.getMenuid()).collect(Collectors.toList());

            //格式化子菜单
            List<JSONObject> collect2 = collect1.stream().map(item2 -> {
                return menuToJson(item2);
            }).collect(Collectors.toList());
            jsonObject.put("child", collect2);
            return jsonObject;
        }).collect(Collectors.toList());
        return child;
    }

    @Override
    public List findMenus() {
        List<Menu> menus = menuExtMapper.findMenus(null);
        return menus;
    }

    @Override
    public Menu getMenuById(Integer menuid) {
        Menu menu = menuMapper.selectByPrimaryKey(menuid);
        return menu;
    }

    @Override
    public List<Map> getParentMenuIdAndName() {
        List<Map> list = menuExtMapper.getParentMenuIdAndName("0");
        return list;
    }

    @Override
    public int updateMenu(Menu menu) {
        int i = menuMapper.updateByPrimaryKeySelective(menu);
        return i;
    }

    @Override
    public int deleteMenuById(Integer menuid) {
        int i = menuMapper.deleteByPrimaryKey(menuid);
        return i;
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public List getMenuJsonSelect(Menu menu) {
        menu.setIsshow(0);
        menu.setNodetype("1");
        List<Menu> menus = menuExtMapper.findMenus(menu);
        List<Menu> collect = menus.stream().filter(item -> item.getPmenuid() == 0).collect(Collectors.toList());
        List<JSONObject> child = collect.stream().map(item -> {
            //判断是否显示
            JSONObject jsonObject = menuToJsonSelect(item);

            //得到子菜单
            List<Menu> collect1 = menus.stream().filter(item1 -> item1.getPmenuid() == item.getMenuid()).collect(Collectors.toList());

            //格式化子菜单
            List<JSONObject> collect2 = collect1.stream().map(item2 -> {
                return menuToJsonSelect(item2);
            }).collect(Collectors.toList());
            jsonObject.put("children", collect2);
            return jsonObject;
        }).collect(Collectors.toList());
        return child;
    }

    /**
     * 格式化菜单数据
     * @param menu
     * @return
     */
    public JSONObject menuToJson(Menu menu) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", menu.getName());
        jsonObject.put("icon", menu.getPicurl());
        jsonObject.put("href", menu.getMenuurl());
        jsonObject.put("target", menu.getTarget());
        return jsonObject;
    }

    /**
     * 格式化菜单数据
     * @param menu
     * @return
     */
    public JSONObject menuToJsonSelect(Menu menu) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", menu.getMenuid());
        jsonObject.put("name", menu.getName());
        jsonObject.put("open", true);
        jsonObject.put("checked", true);
        return jsonObject;
    }
}
