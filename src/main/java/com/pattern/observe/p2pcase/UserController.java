package com.pattern.observe.p2pcase;

public class UserController {
    private UserService userService;
    private PromotionService promotionService;

    //用户首次注册成功后，给用户发放投资体验金
    public Long register(String telephone,String password){
        //省略输入参数的校验
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
