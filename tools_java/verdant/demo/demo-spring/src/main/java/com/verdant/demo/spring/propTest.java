package com.verdant.demo.spring;
import com.verdant.jtools.common.spring.utils.SpringPropUtils;
/**
 * Created by verdant on 2016/1/15.
 */
public class propTest {
    public static void main(String[] args) {
//        AuthorizeStorageUtil.put(user.getAuth(), user);
//        (T) AuthorizeStorageUtil.get(prefix + ":" + tokenValue, clazz);
//        InfoCustomer user = UserUtil.getUser(TokenConst.INFO, InfoCustomer.class);
//        AuthorizeStorageUtil.remove(prefix + ":" + tokenValue);
//        System.out.println(SpringPropUtils.get("mysql.client"));
        System.out.println(SpringPropUtils.getPattern("mysql.*"));
    }
}
