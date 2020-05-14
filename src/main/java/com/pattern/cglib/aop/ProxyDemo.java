package com.pattern.cglib.aop;

public class ProxyDemo {

    public static void main(String[] args) {
        Payment proxy = new AliPay(new RealPayment());
        proxy.pay();
    }

}
