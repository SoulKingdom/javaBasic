package com.java.konwledge.basicinfo.generaotr;

public class GeneraotrRun {
    public static void main(String[] args) {
        RealGenerator rg = new RealGenerator();
        rg.setDriverName("com.mysql.jdbc.Driver");
        rg.setUsername("root");
        rg.setPassword("root");
        rg.setUrl("jdbc:mysql://10.22.17.242:3306/smartcampus?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&tinyInt1isBit=false&serverTimezone=GMT%2B8");
        //自己名字
        rg.setAuthor("Haoxin.Liu");
        //表名 可以多个表
        rg.setIncludeTables(new String[]{"t_security_blacklist"});
        //包名
        rg.setPackageName("com.neusoft.test");
        rg.run();
    }
}
