package com.spring.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Collections;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        /*ApplicationContext context = new FileSystemXmlApplicationContext("D:\\MyWorkspace\\algorithm\\src\\main\\resources\\Beams.xml");
        HelloWord obj = (HelloWord)context.getBean("helloWorld");
        obj.getMessage();*/
        int a = 1;
        List<Integer> list = Collections.singletonList(a);
        System.out.println(list.toString());
    }

}
