package com.yeyu.service;

import com.yeyu.common.Page;
import com.yeyu.pojo.Role;

/**
 * @program: my-admin
 * @description: 请求日志业务接口类
 * @author: ganzj
 * @create: 2020-11-13 15:54
 */
public interface RequestLogService {
    void getAllRequestLogPage(Role role, Page page);
}
