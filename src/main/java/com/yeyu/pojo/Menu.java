package com.yeyu.pojo;

import lombok.Data;

@Data
public class Menu {
    private Integer menuid;

    private String name;

    private Integer pmenuid;

    private String plantype;

    private String nodetype;

    private String menuurl;

    private String target;

    private String picurl;

    private Integer seqno;

    private Integer isshow;
}