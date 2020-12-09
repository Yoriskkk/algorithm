package com.spring.ioc.reflect;

import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws Exception {

        String str = "com.yoriskk.Alipay";
        Class cls = Class.forName(str);
        Object o = cls.newInstance();
        Method payOnline = cls.getMethod("payOnline");
        payOnline.invoke(o);

    }
}
