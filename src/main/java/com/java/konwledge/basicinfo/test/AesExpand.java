package com.java.konwledge.basicinfo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

/**
 * 高级加密标准（英语：Advanced Encryption Standard
 * 稍微扩展了下
 *
 * @author Norton Lai
 * @created 2019-5-14 上午9:18:02
 */
public class AesExpand {

    /**
     * 日志记录器
     * @Fields LOG
     */
    private static Logger log = LoggerFactory.getLogger(AesExpand.class);

    // static String data = "123456RWEQR";
    /**
     *  16位 秘钥 使用时候用genvi方法重新生成过
     */
    private static String key = "abcdef0123456789";
    /**
     *  16位 偏移量 使用时候用genvi方法重新生成过
     */
    private static String iv = "0123456789abcdef";
    // 16位
    private static String orig = "0123456789abcdef";

    public static void main(String args[]) throws Exception {
        String passwordScret = encryptAESExpand("admin");
        log.info("用户原密码是:[{}]", "admin");
        log.info("用户加密密码是:[{}]", passwordScret);
        log.info("用户解密密码是:[{}]", decryptAESExpand(passwordScret));
    }

    public static String genIv() {
        char[] chars = orig.toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            int idx = r.nextInt(16);
            sb.append(chars[idx]);
        }
        return sb.toString();
    }

    /**
     * 加密
     * @param data
     * @return
     * @throws Exception
     * @author Norton Lai
     * @created 2019-5-14 上午10:54:50
     */
    public static String encryptAESExpand(String data) {
        try {
            // 参数分别代表 算法名称/加密模式/数据填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/NOPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            String encode = new sun.misc.BASE64Encoder().encode(encrypted);
            //如果数据过长base64会自动添加换行符
            encode = encode.replaceAll(System.lineSeparator(), "");

            return getChar(9) + encode;

        } catch (Exception e) {
            log.error("加密错误" + e.getMessage(), e);
            return null;
        }
    }

    /**
     * 随机固定数目字符串
     * @param length
     * @return
     * @author Norton Lai
     * @created 2019-5-14 上午10:57:56
     */
    public static String getChar(int length) {
        char[] ss = new char[length];
        int i = 0;
        while (i < length) {
            int f = (int) (Math.random() * 3);
            if (f == 0) {
                ss[i] = (char) ('A' + Math.random() * 26);
            } else if (f == 1) {
                ss[i] = (char) ('a' + Math.random() * 26);
            } else {
                ss[i] = (char) ('0' + Math.random() * 10);
            }
            i++;
        }
        String str = new String(ss);
        return str;
    }

    /**
     * 解密
     * @param data
     * @return
     * @throws Exception
     * @author Norton Lai
     * @created 2019-5-14 上午10:54:33
     */
    public static String decryptAESExpand(String data) {
        try {
            data = data.substring(9);

            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NOPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original).trim();
            return originalString;
        } catch (Exception e) {
            log.error("解密错误" + e.getMessage(), e);
            return null;
        }
    }
}
