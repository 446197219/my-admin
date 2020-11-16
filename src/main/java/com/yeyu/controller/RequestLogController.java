package com.yeyu.controller;

import com.yeyu.common.Page;
import com.yeyu.common.R;
import com.yeyu.pojo.Role;
import com.yeyu.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: my-admin
 * @description: 请求日志控制类
 * @author: ganzj
 * @create: 2020-11-13 15:53
 */
@Controller
@RequestMapping("/requestLog")
public class RequestLogController {

    @Autowired
    RequestLogService requestLogService;
    /**
     * 分页查询所有角色信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllRequestLogPage")
    public R getAllRequestLogPage(Role role, Page page){
        requestLogService.getAllRequestLogPage(role,page);
        return R.ok().put("page",page);
    }
}
