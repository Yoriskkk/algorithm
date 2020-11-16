package com.spring.ioc.controller;

import com.spring.ioc.MyAutoWired;
import com.spring.ioc.service.UserService;

public class UserController {

    @MyAutoWired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
