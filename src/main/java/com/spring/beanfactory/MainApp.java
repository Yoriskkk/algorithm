package com.spring.beanfactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class MainApp {

    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beams.xml"));
        HelloWord obj = (HelloWord) factory.getBean("helloWorld");
        obj.getMessage();
    }

}
