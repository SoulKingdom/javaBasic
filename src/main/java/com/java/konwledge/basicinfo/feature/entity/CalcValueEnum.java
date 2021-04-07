package com.java.konwledge.basicinfo.feature.entity;

import java.util.HashMap;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description 数学计算值
 *  @author HaoXin.Liu
 *  @date 2021/1/26 15:30
 **/
public enum CalcValueEnum {
    /**
     * 数学计算值
     */
    MATH_CALC_EVEN_NUM("偶数被除数", 2);

    private String name;

    private Integer value;


    private static final Map<Integer, CalcValueEnum> MAPPINGS = new HashMap<>(values().length);

    static {
        for (final CalcValueEnum value : values()) {
            MAPPINGS.put(value.getValue(), value);
        }
    }

    private CalcValueEnum(final String name, final Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public Byte byteValue() {

        return Byte.valueOf(value.byteValue());
    }

    public Integer intValue() {

        return Integer.valueOf(value);
    }

    public static CalcValueEnum resolve(final String value) {

        final CalcValueEnum name = MAPPINGS.get(value);
        if (name == null) {
            throw new IllegalArgumentException(String.format("[%s] isn't one of %s", value, MAPPINGS.keySet()));
        }
        return name;
        //        return (value != null ? MAPPINGS.get(value) : null);
    }

    public static CalcValueEnum resolve(final Byte value) {

        if (value != null) {
            final CalcValueEnum name = MAPPINGS.get(value.toString());
            if (name == null) {
                throw new IllegalArgumentException(String.format("[%s] isn't one of %s", value, MAPPINGS.keySet()));
            }
            return name;
        }
        return null;
        //        return (value != null ? MAPPINGS.get(value) : null);
    }

    public static CalcValueEnum resolveAllowNull(final String value) {

        return (value != null ? MAPPINGS.get(value) : null);
    }

    public static CalcValueEnum resolveAllowNull(final Byte value) {

        if (value != null) {
            return (value != null ? MAPPINGS.get(String.valueOf(value)) : null);
        }
        return null;

    }

    public static Integer resolveValue(final Integer value) {

        final CalcValueEnum name = MAPPINGS.get(value);
        if (name == null) {
            throw new IllegalArgumentException(String.format("[%s] isn't one of %s", value, MAPPINGS.keySet()));
        }
        return name.getValue();
        //        return (value != null ? MAPPINGS.get(value) : null);
    }

    public static Integer resolveValueAllowNull(final Integer value) {

        final CalcValueEnum name = (value != null ? MAPPINGS.get(value) : null);
        return name != null ? name.getValue() : null;
        //        return (value != null ? MAPPINGS.get(value) : null);
    }

    public static CalcValueEnum resolveOrDefault(final String value, final CalcValueEnum defalt) {

        if (value != null) {
            final CalcValueEnum reviewResult = MAPPINGS.get(value);
            return reviewResult != null ? reviewResult : defalt;
        }
        return null;
    }

    public static String getName(final String value) {

        final CalcValueEnum resolve = resolve(value);
        return resolve != null ? resolve.getName() : "";
    }

    public boolean matches(final String value) {

        return (this == resolve(value));
    }

    public static Map<Integer, CalcValueEnum> getMapping() {

        return MAPPINGS;
    }

    @Override
    public String toString() {

        return String.format("%s:{%s:%s}", name(), this.value, this.name);
    }

}