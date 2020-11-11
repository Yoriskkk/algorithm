package com.spring.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\MyWorkspace\\algorithm\\src\\main\\resources\\Beams.xml");
        HelloWord obj = (HelloWord)context.getBean("helloWorld");
        obj.getMessage();
    }

}
