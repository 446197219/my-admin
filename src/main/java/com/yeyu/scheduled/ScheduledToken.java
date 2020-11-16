//package com.yeyu.scheduled;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.yeyu.dao.WxTokenMapper;
//import com.yeyu.model.WeChatFinalValue;
//import com.yeyu.pojo.WxToken;
//import com.yeyu.util.DateUtil;
//import com.yeyu.util.HttpClientUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @program: yeyu1
// * @description: 微信公众号定时获取token
// * @author: ganzj
// * @create: 2020-09-19 13:21
// */
//@Slf4j
//@Component
//public class ScheduledToken implements InitializingBean {
//
//    @Autowired
//    WxTokenMapper wxTokenMapper;
//
////    @Scheduled(cron = "0/1 * * * * ? ")
////    public void  test(){
////        System.out.println("定时器："+System.currentTimeMillis());
////    }
//
//
//    @Scheduled(cron = "0 0 0/1 * * ?   ")
//    @Transactional
//    public void  getWxToken(){
//        String url = WeChatFinalValue.ACCESS_TOKEN_URL;
//        url =url.replaceAll("APPID",WeChatFinalValue.APPID);
//        url =url.replaceAll("APPSECRET",WeChatFinalValue.APPSECRET);
//        System.out.println(url);
//        //请求接口获取token
//        String s = HttpClientUtil.doGet(url);
//        JSONObject jsonObject = JSON.parseObject(s);
//        log.info("获取token json字符串:{{}}",jsonObject.toString());
//        String access_token = jsonObject.getString("access_token");
//        String expires_in = jsonObject.getString("expires_in");
//        log.info("json参数access_token： {{}}",access_token);
//        log.info("json参数expires_in： {{}}",expires_in);
//        //刷新数据库
//        WxToken wxToken = new WxToken();
//        wxToken.setId(1);
//        wxToken.setAccesstoken(access_token);
//        wxToken.setTokentime(expires_in);
//        wxToken.setUpdatetime(DateUtil.getCurrentDay(DateUtil.DATE_TIME));
//        wxTokenMapper.updateByPrimaryKeySelective(wxToken);
//        //刷新程序中缓存的token
//        WeChatFinalValue.TOKEN = access_token;
//        log.warn("更新TOKEN成功");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        this.getWxToken();
//    }
//}
