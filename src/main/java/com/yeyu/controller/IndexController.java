package com.yeyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: my-admin
 * @description: 跳转页面控制器
 * @author: ganzj
 * @create: 2020-09-20 08:36
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String indexHtml(){
        return "page/index";
    }

}
