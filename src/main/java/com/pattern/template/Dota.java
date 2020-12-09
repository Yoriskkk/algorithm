package com.pattern.template;

public class Dota extends Game {

    @Override
    void initialize() {
        System.out.println("dota初始化");
    }

    @Override
    void startPlay() {
        System.out.println("补刀、对线、平推");
    }

    @Override
    void endPlay() {
        System.out.println("世界之树倒塌");
    }
}
