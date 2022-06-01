package com.htc.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletInitConfig extends AbstractDispatcherServletInitializer {
    //加载SpringMVC容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMVCConfig.class);
        return ctx;
    }
    //指定哪些请求指定SpringMVC处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  //所有请求
    }
    //加载Spring容器配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
