package com.verdant.jtools.spring.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 配置文件初始化存取bean
 */
public class ContextUtils extends ApplicationObjectSupport {


    private static ApplicationContext applicationContext;

    @PostConstruct
    private void initialize() {
        applicationContext = getApplicationContext();
    }

    /**
     * 获取对象
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    public static <T> T getBean(String name,Class<T> clazz) {
        return applicationContext.getBean(name,clazz);
    }

    public static WebApplicationContext getWebAppContext() {
        return ContextLoader.getCurrentWebApplicationContext();
    }

    public static MessageSource getMessageSource() {
        return ContextUtils.getBean(MessageSource.class);
    }

    public static String getMessage(String code) {
        return getMessageSource().getMessage(code, (Object[]) null, code + " is undefined|999", LocaleContextHolder.getLocale());
    }


}
