package com.pattern.template;

public class Demo {
    public static void main(String[] args) {
        Game dota = new Dota();
        dota.play();
        System.out.println("------------");
        Game autoChess = new AutoChess();
        autoChess.play();
    }
}
