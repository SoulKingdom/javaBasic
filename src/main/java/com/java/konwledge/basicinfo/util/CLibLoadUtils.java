package com.java.konwledge.basicinfo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * clib加载工具类
 *
 * @author liuhaoxin
 */
public class CLibLoadUtils {

    private static Logger logger = LoggerFactory.getLogger(CLibLoadUtils.class);

    public static String getDllBySystem(String path, String libName) {
        //系统 Windows 或者 Linux
        String osName = System.getProperties().getProperty("os.name").toLowerCase();
        //架构 x86 或者 amd64
        String osArch = System.getProperties().getProperty("os.arch").toLowerCase();
        logger.info("this OS is : [{}] ; [{}]", osName, osArch);
        String fileName = null;
        //64位
        if (osArch.contains("64")) {
            if (osName.contains("win")) {
                fileName = path + File.separator + "windows" + File.separator + "x64" + File.separator + libName + ".dll";
            } else {
                fileName = path + File.separator + "linux" + File.separator + "x64" + File.separator + "lib" + libName + ".so";
            }
        }
        //32位
        else if (osArch.contains("86")) {
            if (osName.contains("win")) {
                fileName = path + File.separator + "windows" + File.separator + "x86" + File.separator + libName + ".dll";
            } else {
                fileName = "x86" + File.separator + "lib" + libName + ".so";
            }
        } else {//不支持的
            throw new RuntimeException("This OS is not support！");
        }
        return fileName;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("LY");
        System.out.println(sb.append(String.format("%03d", 1)).toString());
    }
}
