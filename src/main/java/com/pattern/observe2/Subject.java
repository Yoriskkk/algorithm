package com.pattern.observe2;

/**
 * 被观察者
 */
public interface Subject {

    /**
     * 注册
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知
     * @param message
     */
    void notifyObservers(Message message);
}
