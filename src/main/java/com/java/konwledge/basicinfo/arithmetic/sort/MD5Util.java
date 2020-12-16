package com.java.konwledge.basicinfo.arithmetic.sort;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  @dept 上海软件研发中心
 *  @description MD5加密
 *  @author HaoXin.Liu
 *  @date 2020/3/4 16:23
 **/
public class MD5Util {
    /**
     * 生成MD5
     *
     * @dept 上海软件研发中心
     * @param message
     * @return 获取md5加密
     * @author HaoXin.Liu
     * @date 2020/3/4 16:27
     **/
    public static String getMD5(String message) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(message.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            message = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return message;
    }

}