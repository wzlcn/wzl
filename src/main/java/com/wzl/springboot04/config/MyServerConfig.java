package com.wzl.springboot04.config;

import com.wzl.springboot04.component.MyServlet;
import com.wzl.springboot04.fileter.MyFilter;
import com.wzl.springboot04.listener.MyListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/MyServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/MyServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean MyListener() {
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return listenerRegistrationBean;
    }
}
