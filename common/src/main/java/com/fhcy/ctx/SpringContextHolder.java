package com.fhcy.ctx;

import org.springframework.context.ApplicationContext;

import java.util.Map;

public class SpringContextHolder {

    private static ApplicationContext ctx;

    public SpringContextHolder(ApplicationContext ctx) {
        SpringContextHolder.ctx = ctx;
    }

    public static Object getBean(String name) {
        return ctx.getBean(name);
    }

    public static <T> T getBean(Class<T> classType) {
        return ctx.getBean(classType);
    }

    public static <T> T getBean(String name, Class<T> classType) {
        return ctx.getBean(name, classType);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> classType) {
        return ctx.getBeansOfType(classType);
    }
}
