package com.verdant.demo.common.bytecode.base.loader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * <p>文件名称：MyClassLoader2.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2016-2099</p>
 * <p>公   司： 优行科技 </p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>创建日期：2017/2/25</p>
 *
 * @author congyu.yang@geely.com
 * @version 1.0
 */
public class MyClassLoader2 extends URLClassLoader {

    public MyClassLoader2(URL[] urls) {
        super(urls);
    }

    public MyClassLoader2(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public void addJar(URL url) {
        this.addURL(url);
    }
}
