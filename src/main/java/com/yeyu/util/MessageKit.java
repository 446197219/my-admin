package com.yeyu.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: my-admin
 * @description: 公众号消息格式转换
 * @author: ganzj
 * @create: 2020-09-27 22:21
 */
@Slf4j
public class MessageKit {

    public static Map<String,String> req2Map(HttpServletRequest request) throws IOException {
        try {
            String xml = req2Xml(request);
            if(!StringUtils.isEmpty(xml)){
                log.debug("xml数据：{{}}",xml);
                Map<String, String> map = new HashMap<>();
                Document document = DocumentHelper.parseText(xml);
                Element rootElement = document.getRootElement();
                List<Element> elements = rootElement.elements();
                for (Element e : elements) {
                    map.put(e.getName(), e.getTextTrim());
                }
                return map;
            }
        }catch (DocumentException e){
            e.printStackTrace();
        }
        return null;
    }

    //获取输入流的xml数据
    public static String req2Xml(HttpServletRequest request) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = br.readLine()) != null){
            buffer.append(str);
        }
        return buffer.toString();
    }
}
