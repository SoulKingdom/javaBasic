package com.java.konwledge.basicinfo.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description XML数据操作
 *  @author HaoXin.Liu
 *  @date 2020/7/21 9:57
 **/
public class XmlUtils {

    /**定义解析器*/
    private SAXReader saxReader;
    /**文档对象*/
    private Document document;

    public XmlUtils(String path) {
        //获取解析器
        saxReader = new SAXReader();
        try {
            //获取文档对象
            document = saxReader.read(path);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 根据节点名称获取内容
     * @param name 节点名称
     * @return 节点内容
     */
    public String getElementText(String name) {
        //定位根节点
        Element root = document.getRootElement();
        //根据名称定位节点
        Element element = root.element(name);
        String content = element.getText();
        if (null == content || content.equals("")) {
            //
        }
        //返回节点内容
        return element.getText();
    }

    public static void node(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
                }
            }
        }
    }

    public static void main(String[] args) throws DocumentException, ParserConfigurationException {
        //解析方式1 通过list 找到固定的table列表
        parseXmlMethod1();
        //解析方式2 通过字符类型
        parseXmlMethod2();
        //解析方式3 dom方式
        //获取Xml数据
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Countries>\n" +
                "    <Country>\n" +
                "        <Country_Name>Spain</Country_Name>\n" +
                "        <Country_Capital>Madrid</Country_Capital>\n" +
                "        <Country_Continent>Europe</Country_Continent>\n" +
                "    </Country>\n" +
                "    <Country>\n" +
                "        <Country_Name>USA</Country_Name>\n" +
                "        <Country_Capital>Washington</Country_Capital>\n" +
                "        <Country_Continent>America</Country_Continent>\n" +
                "    </Country>\n" +
                "    <Country>\n" +
                "        <Country_Name>Japan</Country_Name>\n" +
                "        <Country_Capital>Tokyo</Country_Capital>\n" +
                "        <Country_Continent>Asia</Country_Continent>\n" +
                "    </Country>\n" +
                "</Countries>";
        //Country country =JaxbUtil.converyToJavaBean(xmlStr,Country.class);
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document document = null;
        try {
            InputStream iStream = new ByteArrayInputStream(xmlStr.getBytes());
            document = builder.parse(iStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NodeList sList = document.getElementsByTagName("GetAlarmTypeResponse");
        node(sList);

    }

    private static void parseXmlMethod2() {
        //获取Xml数据
        String xmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "    <soap:Body>\n" +
                "        <GetAlarmTypeResponse xmlns=\"YKITSJLW\">\n" +
                "            <GetAlarmTypeResult>报警,断电,调校,超量程,分站故障,不巡检,暂停,传感器故障</GetAlarmTypeResult>\n" +
                "        </GetAlarmTypeResponse>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";
        int indexbegin = xmlStr.indexOf("<GetAlarmTypeResult>");
        int indexend = xmlStr.indexOf("</GetAlarmTypeResult>");
        System.out.println("<TrmSeqNum>的位置===" + indexbegin);
        System.out.println("</TrmSeqNum>的位置===" + indexend);
        // 截取指定index之间的数据
        String jsonStr = xmlStr.substring(indexbegin + "<GetAlarmTypeResult>".length(), indexend);
        System.out.println(jsonStr);
    }

    private static void parseXmlMethod1() throws DocumentException {
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

        SAXReader sr = new SAXReader();
        // 传入需要解析的数据
        Document document = sr.read(new ByteArrayInputStream(str.getBytes()));
        Element root = document.getRootElement();
        elementList = root.elements();
        for (Element e : elementList) {
            // 解析标签下一级标签
            Element e1 = e.element("GetAlarmTypeResponse");
            List<Element> elementList1 = e1.elements();
            elementList1.stream().forEach(o -> System.out.println(o.getText())
            );
            System.out.println(e1.elementText("GetAlarmTypeResult"));
        }
    }
}