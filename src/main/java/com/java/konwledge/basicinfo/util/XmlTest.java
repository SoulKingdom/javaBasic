package com.java.konwledge.basicinfo.util;

import java.util.ArrayList;
import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/22 10:37
 **/
public class XmlTest {

    public static void main(String[] args) {
        //getXmlTest1();
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response version=\"1.0\" cmdId=\"\" cmdUrl=\"reqLogin\">\n" +
                "\t<status>success</status>\n" +
                "\t<content>\n" +
                "\t\t<sessionId>{6BB1F818-73C9-1545-B8DA-92F73E072361}</sessionId>\n" +
                "\t\t<nonce>{436C4202-DC82-A24E-9D45-65D007BBECB5}</nonce>\n" +
                "\t\t<token>{31DA1464-D32B-2245-9EBC-8F6518AF2A8A}</token>\n" +
                "\t\t<softwareVersion><![CDATA[1.4.4.37920B200617.N0P.U1(8A818).beta.P2]]></softwareVersion>\n" +
                "\t</content>\n" +
                "</response>";
        JaxbUtil resultBinder = new JaxbUtil(YiTuTokenInfo.class);
        YiTuTokenInfo yiTuTokenInfo = resultBinder.fromXml(str);
        System.out.println(yiTuTokenInfo.toString());

    }

    private static void getXmlTest1() {
        //创建java对象

        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setName("name1");

        RoomTypeVO t1 = new RoomTypeVO();
        t1.setPrice("20");
        t1.setTypeid(1);
        t1.setTypename("typename1");

        RoomTypeVO t2 = new RoomTypeVO();
        t2.setPrice("30");
        t2.setTypeid(2);
        t2.setTypename("typename2");


        List<RoomTypeVO> RoomTypeVOs = new ArrayList<RoomTypeVO>();
        RoomTypeVOs.add(t1);
        RoomTypeVOs.add(t2);
        hotel.setRoomTypeVOs(RoomTypeVOs);


        //将java对象转换为XML字符串
        JaxbUtil requestBinder = new JaxbUtil(Hotel.class,
                JaxbUtil.CollectionWrapper.class);
        String retXml = requestBinder.toXml(hotel, "utf-8");
        System.out.println("xml:" + retXml);

        //将xml字符串转换为java对象
        JaxbUtil resultBinder = new JaxbUtil(Hotel.class,
                JaxbUtil.CollectionWrapper.class);
        Hotel hotelObj = resultBinder.fromXml(retXml);

        System.out.println("hotelid:" + hotelObj.getId());
        System.out.println("hotelname:" + hotelObj.getName());
        for (RoomTypeVO roomTypeVO : hotelObj.getRoomTypeVOs()) {
            System.out.println("Typeid:" + roomTypeVO.getTypeid());
            System.out.println("Typename:" + roomTypeVO.getTypename());
        }
    }
}