package com.pattern.observe2;

import javax.swing.*;

/**
 * 观察者
 */
public interface Observer {

    /**
     * 更新
     * @param message
     */
    void update(Message message);

}
