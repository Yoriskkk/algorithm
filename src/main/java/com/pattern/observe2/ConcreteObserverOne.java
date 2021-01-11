package com.pattern.observe2;

public class ConcreteObserverOne implements Observer {
    /**
     * 更新
     *
     * @param message
     */
    @Override
    public void update(Message message) {

        //TODO: 获取消息通知，执行自己的逻辑
        System.out.println("ConcreteObserverOne is notified.");

    }
}
