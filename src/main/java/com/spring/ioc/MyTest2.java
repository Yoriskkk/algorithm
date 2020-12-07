package com.spring.ioc;

import com.spring.ioc.controller.UserController;
import com.spring.ioc.service.UserService;
import org.junit.Test;

import java.util.stream.Stream;

public class MyTest2 {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //获取所有的属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field->{
            String name = field.getName();
            MyAutoWired annotation = field.getAnnotation(MyAutoWired.class);
            if(annotation!=null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }
}
