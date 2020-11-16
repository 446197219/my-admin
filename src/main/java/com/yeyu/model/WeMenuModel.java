package com.yeyu.model;

import lombok.Data;

/**
 * @program: my-admin
 * @description: 微信菜单模型
 * @author: ganzj
 * @create: 2020-09-19 14:35
 */
@Data
public class WeMenuModel {

    private int id;
    private String name;
    private String url;
    private String appid;
    private String pagepath;
    private String key;
    private String type;
    private WeMenuModel[] sub_button;

}
