package com.pattern.cglib.aop;

import org.omg.PortableInterceptor.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {

    private RealPayment realPayment;

    private Object proxiedObject;

    public DynamicProxyHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(proxiedObject, args);
        realPayment.pay();
        return result;
    }
}
