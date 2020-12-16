package com.java.konwledge.basicinfo.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.util.*;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/21 11:21
 **/
public class XmlUtil {
    /**
     * 日志服务
     */
    private static Logger LOG = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * 解析XML为Document对象
     *
     * @param xml
     *            被解析的XMl
     * @return Document
     */
    public static Element parseXml(String xml) {
        Document document = null;
        //
        StringReader sr = new StringReader(xml);
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(sr);
        } catch (DocumentException e) {
            LOG.error("解析失败", e);
        }
        return null == document ? null : document.getRootElement();
    }

    /**
     * 获取element对象的text的值
     *
     * @param em
     *            节点的对象
     * @param tag
     *            节点的tag
     * @return 节点
     */
    public static String getText(Element em, String tag) {
        if (null == em) {
            return null;
        }
        Element e = em.element(tag);
        //
        return null == e ? null : e.getText();
    }

    /**
     * 递归解析xml节点，适用于 多节点数据
     *
     * @param node
     *            node
     * @param nodeName
     *            nodeName
     * @return List<Map < String, Object>>
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> listNodes(Element node, String nodeName) {
        if (null == node) {
            return null;
        }
        // 初始化返回
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        // 首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();

        Map<String, Object> map = null;
        // 遍历属性节点
        for (Attribute attribute : list) {
            if (nodeName.equals(node.getName())) {
                if (null == map) {
                    map = new HashMap<String, Object>();
                    listMap.add(map);
                }
                // 取到的节点属性放到map中
                map.put(attribute.getName(), attribute.getValue());
            }

        }
        // 遍历当前节点下的所有节点 ，nodeName 要解析的节点名称
        // 使用递归
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            listMap.addAll(listNodes(e, nodeName));
        }
        return listMap;
    }


    public static void main(String[] args) throws DocumentException {
        //获取Xml数据
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "    <soap:Body>\n" +
                "        <GetAlarmTypeResponse xmlns=\"YKITSJLW\">\n" +
                "            <GetAlarmTypeResult>报警,断电,调校,超量程,分站故障,不巡检,暂停,传感器故障</GetAlarmTypeResult>\n" +
                "        </GetAlarmTypeResponse>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";
        List<Element> elementList = null;
        Element root = XmlUtil.parseXml(str);
        elementList = root.elements();
        for (Element e : elementList) {
           Element e1 = e.element("GetAlarmTypeResponse");
            List<Element> elementList1 = e1.elements();
            for (Element e2:elementList1) {
                System.out.println(e2.elementText("GetAlarmTypeResult"));
            }
        }

    }
}