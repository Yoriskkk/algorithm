package com.pattern.observe2;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new ArrayList<Observer>();

    /**
     * 注册
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 移除
     *
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知
     *
     * @param message
     */
    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observerList){
            observer.update(message);
        }
    }
}
