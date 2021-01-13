package com.pattern.observe2;

public class ConcreteObserverThree implements Observer {
    /**
     * 更新
     *
     * @param message
     */
    @Override
    public void update(Message message) {

        //TODO: 获取消息通知，执行自己的逻辑
        System.out.println("ConcreteObserverThree is notified.");

    }
}
