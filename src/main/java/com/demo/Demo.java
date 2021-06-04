package com.demo;
import org.apache.commons.lang.SerializationUtils;

public class Demo {

    public static void main(String[] args) {

        User user = new User();
        User clone = (User)SerializationUtils.clone(user);
        user.equals(clone);

    }

}
