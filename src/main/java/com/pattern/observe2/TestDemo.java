package com.pattern.observe2;

public class TestDemo {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.registerObserver(new ConcreteObserverThree());
        subject.notifyObservers(new Message());
    }

}
