package com.java.konwledge.basicinfo.util;

import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author : leih
 * @Date : 2020/5/12 17:12
 * @Version : 1.0
 * @Description : TODO
 * @ClassName : PasswordUtils
 */
public class PasswordUtils {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "yitutech123";
        String nonce = "{4A0DDA06-53D1-0342-B0FD-6F8453A0E82B}";

        String md5 = getUpMd5Str(password);
        System.out.println(md5);

        String sha1Str = getUpSha1Str(md5.toUpperCase(), nonce);
        System.out.println(sha1Str.toUpperCase());

        String str = String.format("rtmp://%s:1935/channel/%s","10.22.17.249", "249通道");
        System.out.println(str);
    }

    //获取大写的md5值
    public static String getUpMd5Str(String sourceStr) throws NoSuchAlgorithmException {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    sourceStr.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code.toUpperCase();
    }

    /**
     * sha1加密
     *
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getUpSha1Str(String data, String sale) throws NoSuchAlgorithmException {
        //加盐   更安全一些
        data += sale;
        //信息摘要器                                算法名称
        MessageDigest md = MessageDigest.getInstance("SHA1");
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //使用指定的字节来更新我们的摘要
        md.update(b);
        //获取密文  （完成摘要计算）
        byte[] b2 = md.digest();
        //获取计算的长度
        int len = b2.length;
        //16进制字符串
        String str = "0123456789abcdef";
        //把字符串转为字符串数组
        char[] ch = str.toCharArray();

        //创建一个40位长度的字节数组
        char[] chs = new char[len * 2];
        //循环20次
        for (int i = 0, k = 0; i < len; i++) {
            byte b3 = b2[i];//获取摘要计算后的字节数组中的每个字节
            // >>>:无符号右移
            // &:按位与
            //0xf:0-15的数字
            chs[k++] = ch[b3 >>> 4 & 0xf];
            chs[k++] = ch[b3 & 0xf];
        }

        //字符数组转为字符串
        return new String(chs);
    }
}
