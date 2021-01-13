package com.pattern.template;

public class AutoChess extends Game {
    @Override
    void initialize() {
        System.out.println("选择信使");
    }

    @Override
    void startPlay() {
        System.out.println("思考选择什么套路");
    }

    @Override
    void endPlay() {
        System.out.println("成功吃鸡或者死亡");
    }
}
