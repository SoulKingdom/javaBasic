package com.java.konwledge.basicinfo.feature.entity;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2021/1/20 17:05
 **/
public class TestUrl {

    /**
     * 在线图片转换成base64字符串
     * @param imgURL    图片线上路径
     * @return
     */
    public static String ImageToBase64ByOnline(String imgURL) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(imgURL);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        //BASE64Encoder encoder = new BASE64Encoder();
        //return encoder.encode(data.toByteArray());
        return Base64.encodeBase64String(data.toByteArray());
    }

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5, 100, 3000,
            TimeUnit.MICROSECONDS,
            new LinkedBlockingQueue<>(1024),
            new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());


    private static List<String> acceptNeedIssueFaceIdList(List<String> faceIdList, List<String> issueFaceIdList) {
        HashSet hs1 = new HashSet(faceIdList);
        HashSet hs2 = new HashSet(issueFaceIdList);
        hs1.removeAll(hs2);
        List<String> listC = new ArrayList<String>();
        listC.addAll(hs1);
        return listC;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("2", "3", "5");

        List<String> list2 = Arrays.asList("3", "5");

        List<String> list3 =acceptNeedIssueFaceIdList(list1, list2);

        System.out.println(list3);

        System.out.println(list1);


        for (int i = 0; i < 2; i++) {
            executor.execute(() -> {
                String urlBase64 = "";
                if ("http://10.22.17.227:8888/pic/2021/1/20/faceImport2021012017254398032/2020120101-杨航测试-001.png".startsWith("http")) {
                    urlBase64 = ImageToBase64ByOnline("http://10.22.17.227:8888/pic/2021/1/20/faceImport2021012017254398032/2020120101-杨航测试-001.png").replace("\r\n", "").replace("\n", "").replace("\r", "");
                }
                System.out.println(urlBase64);
            });
        }
    }
}