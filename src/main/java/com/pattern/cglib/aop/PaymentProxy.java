package com.pattern.cglib.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PaymentProxy {

    public PaymentProxy(){

    }

    public Object createProxy(Object proxiedObject) {
        Class[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    public void beforePay(){
        System.out.println("从招行取款");
    }

    public void afterPay(){
        System.out.println("支付给慕课网");
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            beforePay();
            Object result = method.invoke(proxiedObject, args);
            afterPay();
            return result;
        }
    }
}
