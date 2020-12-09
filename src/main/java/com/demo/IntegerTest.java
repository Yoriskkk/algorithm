package com.demo;

public class IntegerTest {

    public static final Integer b = 6;

    public static void main(String[] args) {
        User user = new User();
        user.setName("wyy");
        String name = user.getName();
        user.setAge(5);
        Integer a = user.getAge();
        user.setAge(6);
        user.setName("wangyuanye");
        System.out.println(a);
        System.out.println(user.getAge());
        System.out.println(name);
    }
}
