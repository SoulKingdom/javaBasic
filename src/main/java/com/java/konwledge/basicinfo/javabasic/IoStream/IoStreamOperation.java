package com.java.konwledge.basicinfo.javabasic.IoStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;

/**
 *  @dept 上海软件研发中心
 *  @description 流的操作
 *  @author HaoXin.Liu
 *  @date 2019/12/31 10:17
 **/
public class IoStreamOperation {
    public static final Logger log = LoggerFactory.getLogger(IoStreamOperation.class);

    /**
     * 创建文件流 写入
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/12/31 10:22
     **/
    private void createFileWrite() {
        try {
            //创建文件
            FileWriter fw = new FileWriter("demo.txt");
            //数据写入
            fw.append("abc");
            fw.append("def");
            //刷新数据到本地
            fw.flush();
            //关闭写入流
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件流读取
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/12/31 10:31
     **/
    private void createFileStream() {
        try {
            InputStream inputStream = new FileInputStream("demo.txt");
            byte[] bit = new byte[10];
            int num;
            StringBuilder sb = new StringBuilder();
            if ((num = inputStream.read(bit)) != -1) {
                sb.append(bit);
                log.info("数量是："+num+"  数据是:"+ sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
      /*  IoStreamOperation io = new IoStreamOperation();
        //创建文件流写入
        io.createFileWrite();
        io.createFileStream();*/
        //System.out.println("2020-01-08 09:00:00".compareTo("2020-01-08 00:00:00"));
       /* String date = "09";
        System.out.println(Integer.valueOf(date));*/
        System.out.println(getMD5("yitutech123"));
    }


    public static String getMD5(String message) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(message.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            message = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}