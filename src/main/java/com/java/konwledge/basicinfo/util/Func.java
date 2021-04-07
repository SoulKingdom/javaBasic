package com.java.konwledge.basicinfo.util;


public class Func {

    /**
     * 强转string,并去掉多余空格
     *
     * @param str 字符串
     * @return String
     */
    public static String toStr(Object str) {
        return toStr(str, "");
    }
    /**
     * 强转string,并去掉多余空格
     *
     * @param str          字符串
     * @param defaultValue 默认值
     * @return String
     */
    public static String toStr(Object str, String defaultValue) {
        if (null == str) {
            return defaultValue;
        }
        return String.valueOf(str);
    }

    /**
     * Determine whether the given array is empty:
     * i.e. {@code null} or of zero length.
     *
     * @param array the array to check
     * @return 数组是否为空
     */
    public static boolean isEmpty( Object[] array) {
        return ObjectUtil.isEmpty(array);
    }

    public static boolean isBlank(final CharSequence cs) {
        return !StringUtil.hasText(cs);
    }


}
