package com.pattern.cglib.aop;

public class RealPayment implements Payment{
    public void pay() {
        System.out.println("作为用户，我只关心支付功能");
    }
}
