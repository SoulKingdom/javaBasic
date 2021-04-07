package com.java.konwledge.basicinfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/12/18 9:50
 **/
@RestController
@RequestMapping("test")
public class controller {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    private String test() {
        return "helloworld";
    }
}