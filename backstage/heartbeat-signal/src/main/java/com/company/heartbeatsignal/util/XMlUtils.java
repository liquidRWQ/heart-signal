package com.company.heartbeatsignal.util;

import com.company.heartbeatsignal.exception.CheckedException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Liquid
 * @类名： XMlUtils
 * @描述：
 * @date 2019/5/25
 */
public class XMlUtils {

    public static Map<String, String> parseXmlToMap(String xml) throws CheckedException {
        HashMap<String, String> result = new HashMap<>(16);
        Document document;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            throw new CheckedException("xml字符串解析异常: " + e.toString());
        }
        Element rootElement = document.getRootElement();
        Iterator elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element child = (Element) elementIterator.next();
            result.put(child.getName(), child.getText());
        }
        return result;
    }

    public static Map<String, String> parseXmlFileToMap(String filePath) throws CheckedException {
        HashMap<String, String> result = new HashMap<>(16);
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document;
        try {
            document = reader.read(new File(filePath));
        } catch (DocumentException e) {
            throw new CheckedException("文件加载异常：" + e.toString());
        }
        //获取根节点元素对象
        Element rootElement = document.getRootElement();
        Iterator elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element child = (Element) elementIterator.next();
            result.put(child.getName(), child.getText());
        }
        return result;

    }

    public static String formatToXml(Map<String, String> xmlMap) {
        StringBuilder xml = new StringBuilder("<xml version='1.0' encoding='utf-8'>");
        for (Map.Entry<String, String> entry : xmlMap.entrySet()) {
            xml.append("<")
                    .append(entry.getKey())
                    .append(">")
                    .append(entry.getValue())
                    .append("</")
                    .append(entry.getKey())
                    .append(">");
        }
        xml.append("</xml>");
        return xml.toString();
    }


}
