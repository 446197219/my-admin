package com.yeyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.yeyu.common.Page;
import com.yeyu.dao.ext.RequestLogExtMapper;
import com.yeyu.pojo.Role;
import com.yeyu.service.RequestLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: my-admin
 * @description:  请求日志业务接口实现类
 * @author: ganzj
 * @create: 2020-11-13 15:55
 */
@Service
public class RequestLogServiceImpl implements RequestLogService {

    @Resource
    RequestLogExtMapper requestLogExtMapper;

    @Override
    public void getAllRequestLogPage(Role role, Page page) {
        int count = requestLogExtMapper.getCountRequestLogPage(role);
        if(count>0){
            page.setDataCount(count);
            PageHelper.startPage(page.getPageNums(),page.getPageSize());
            List<Role> roles = requestLogExtMapper.getAllRequestLogPage(role);
            page.setData(roles);
        }
    }
}
