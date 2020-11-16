package com.yeyu.common;

import lombok.Data;

/**
 * @program: my-admin
 * @description: 分页模型类
 * @author: ganzj
 * @create: 2020-11-05 14:15
 */
@Data
public class Page<T> {

    int pageNums;
    int pageSize;
    int dataCount;
    T data;
}
