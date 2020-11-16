package com.yeyu.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeyu.common.R;
import com.yeyu.pojo.Menu;
import com.yeyu.pojo.User;
import com.yeyu.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: my-admin
 * @description: 菜单控制类
 * @author: ganzj
 * @create: 2020-09-21 11:47
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * index首页显示菜单数据
     * @return
     */
    @ResponseBody
    @RequestMapping("getMenuJson")
    public JSONObject getMenuJson(Menu menu) {
        Object user = SecurityUtils.getSubject().getPrincipal();
        JSONObject jsonObject = new JSONObject();

        JSONObject homeInfo = new JSONObject();
        homeInfo.put("title","首页");
        homeInfo.put("href","page/welcome.html?t=1");

        JSONObject logoInfo = new JSONObject();
        logoInfo.put("title","小甘首页");
        logoInfo.put("image","images/logo.png");
        logoInfo.put("href","images/logo.png");

        List<JSONObject> menuInfo = new ArrayList<>();
        JSONObject menuInfo1 = new JSONObject();
        menuInfo1.put("title","常规管理");
        menuInfo1.put("icon","fa fa-address-book");
        menuInfo1.put("image","images/logo.png");
        menuInfo1.put("href","images/logo.png");
        menuInfo1.put("target","_self");
        List menuJson = menuService.getMenuJson(menu);
        menuInfo1.put("child",menuJson);

        JSONObject menuInfo2 = new JSONObject();
        menuInfo2.put("title","组件管理");
        menuInfo2.put("icon","fa fa-address-book");
        menuInfo2.put("href","");
        menuInfo2.put("target","_self");
        menuInfo2.put("child",null);

        JSONObject menuInfo3 = new JSONObject();
        menuInfo3.put("title","其它管理");
        menuInfo3.put("icon","fa fa-address-book");
        menuInfo3.put("href","");
        menuInfo3.put("target","_self");
        menuInfo3.put("child",null);

        menuInfo.add(menuInfo1);
        menuInfo.add(menuInfo2);
        menuInfo.add(menuInfo3);

        jsonObject.put("homeInfo",homeInfo);
        jsonObject.put("logoInfo",logoInfo);
        jsonObject.put("menuInfo",menuInfo);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("findMenus")
    public R findMenus(){
        List menus = menuService.findMenus();

        return R.ok().put("count",menus.size()).put("data",menus);
    }

    @ResponseBody
    @RequestMapping("getMenuById")
    public R getMenuById(@RequestParam(value="menuid" , required = true) Integer menuid){
        Menu menu = menuService.getMenuById(menuid);
        return  R.ok().put("menu",menu);
    }


    @ResponseBody
    @RequestMapping("getParentMenuIdAndName")
    public R getMenuById(){
        List<Map> list = menuService.getParentMenuIdAndName();
        return  R.ok().put("parentMenus",list);
    }

    @ResponseBody
    @RequestMapping("updateMenu")
    public R updateMenu(Menu menu){

        int count = menuService.updateMenu(menu);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }

    @ResponseBody
    @RequestMapping("deleteMenuById")
    public R deleteMenuById(@RequestParam(value="menuid" , required = true) Integer menuid){
        int count = menuService.deleteMenuById(menuid);
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("addMenu")
    public R addMenu(Menu menu){
        menu.setPicurl("fa fa-window-maximize");
        int count = menuService.addMenu(menu);
        if(count>0){
            return R.ok();
        }else{
            return R.fail("新增失败");
        }
    }

    @ResponseBody
    @RequestMapping("getMenuJsonSelect")
    public List getMenuJsonSelect(Menu menu){
        return menuService.getMenuJsonSelect(menu);
    }
}
