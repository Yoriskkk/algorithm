package com.spring.ioc;

import com.spring.ioc.controller.UserController;
import com.spring.ioc.service.UserService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyTest {
    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //创建对象
        UserService userService = new UserService();
        //获取所有的属性
        Field serviceFiled = clazz.getDeclaredField("userService");
        //该属性设置为true代表可以访问私有属性
        serviceFiled.setAccessible(true);
        //只有通过方法才能设置具体的属性值
        String name = serviceFiled.getName();
        //拼接方法的名称
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        String setMethodName = "set" + name;
        //通过方法注入属性的对象
        Method method = clazz.getMethod(setMethodName, UserService.class);
        //反射
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }
}
