package com.java.konwledge.basicinfo.util;


public class ObjectUtil extends org.springframework.util.ObjectUtils {


    /**
     * 判断元素不为空
     * @param obj object
     * @return boolean
     */
    public static boolean isNotEmpty( Object obj) {
        return !ObjectUtil.isEmpty(obj);
    }
}
