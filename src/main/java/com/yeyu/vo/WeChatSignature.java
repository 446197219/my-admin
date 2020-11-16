package com.yeyu.vo;

import lombok.Data;

/**
 * @program: my-admin
 * @description:
 * @author: ganzj
 * @create: 2020-09-19 09:48
 */
@Data
public class WeChatSignature {

    String signature;
    String timestamp;
    String nonce;
    String echostr;
            
}
