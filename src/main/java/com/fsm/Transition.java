package com.fsm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 动作，扭转下一个状态节点时，触发的动作，比如邮件发送
 * 维护触发前状态，触发后状态，以及具体的动作内容
 */
@Data
@Slf4j
public abstract class Transition {

    /** 触发事件 **/
    private String eventCode;

    /** 触发当前状态 **/
    private State currState;

    /** 触发后状态 **/
    private State nextState;

    public Transition(String eventCode, State currState, State nextState) {
        this.eventCode = eventCode;
        this.currState = currState;
        this.nextState = nextState;
    }

    /**
     * 执行动作
     * @return
     */
    public State execute(Event event){
        log.info("当前是：{}状态，执行：{}操作后，流转成：{}状态",currState,eventCode,nextState);
        if(this.doExecute(event)){
            return this.nextState;
        }else {
            return null;
        }
    }

    /**
     * 执行动作的具体业务
     * @param event
     * @return
     */
    protected abstract boolean doExecute(Event event);

}
