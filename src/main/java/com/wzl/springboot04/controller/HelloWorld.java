package com.wzl.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorld {
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "Hello World!";
    }

    //查出一些数据，在页面展示
    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好！<h1/>" );
        map.put("users", Arrays.asList("张三","李四"));
        //classpath:/templates/success.html
        return "success";
    }
}
