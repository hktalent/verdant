package com.spring.demo.web.auth;

/**
 * CommonEnum Web接口返回信息
 * Author: verdant
 * Create: 2016/03/14
 */
public enum CommonEnum {
    TOKEN,//令牌name
    USER,//用户name prefix
    CAPTCHA;//验证码 prefix

    private CommonEnum() {
    }
}
