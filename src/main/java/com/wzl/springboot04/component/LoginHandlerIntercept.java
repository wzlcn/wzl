package com.wzl.springboot04.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            //未登录，返回登录页面
            request.setAttribute("msg","没有权限，请先登录" );
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else {
            //已登录，放行
            return true;
        }
    }
}
