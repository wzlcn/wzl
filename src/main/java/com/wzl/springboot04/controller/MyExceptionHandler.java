package com.wzl.springboot04.controller;

import com.wzl.springboot04.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //    @ResponseBody
//    @ExceptionHandler(UserNotExitException.class)
//    public Map<String,Object> handlerException(Exception e){
//
//        Map<String,Object> map=new HashMap<>();
//        map.put("code", "user is not exit");
//        map.put("message", e.getMessage());
//        return map;
//    }
    @ExceptionHandler(UserNotExitException.class)
    public String handlerException(Exception e, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误代码4xx 5xx
        request.setAttribute("javax.servlet.error.statues_code", 500);
        map.put("code", "user is not exit");
        map.put("message", "用户出错了");
        request.setAttribute("ext", map);
        return "forward:/error";
    }

}
