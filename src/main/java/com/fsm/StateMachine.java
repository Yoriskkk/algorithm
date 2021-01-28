package com.fsm;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 状态机，维护该状态机所有支持的状态，以及调用入口
 */
@Slf4j
public abstract class StateMachine {

    /** 定义的所有状态 **/
    private static List<State> allStates = null;

    /**
     * 状态机执行事件
     * 所以请求参数为状态码，和事件
     * 执行完毕之后，返回一个状态
     * 也就是自动机在做的事即：从某一个状态，通过某一个事件，到达下一个状态
     * @param stateCode
     * @param event
     * @return State
     */
    public State execute(String stateCode,Event event){
        State startState = this.getState(stateCode);
        for (Transition transition: startState.getTransitions()) {
            if(event.getEventCode().equals(transition.getEventCode())){
                return transition.execute(event);
            }
        }
        log.error("StateMachine[{}] Can not find transition for stateId[{}] eventCode[{}]", this.getClass().getSimpleName(), stateCode, event.getEventCode());
        return null;
    }

    /**
     * 根据状态码获取到对应的状态
     * @param stateCode
     * @return
     */
    public State getState(String stateCode){
        if(allStates == null){
            log.info("StateMachine declareAllStates");
            allStates = this.declareAllStates();
        }
        for (State state : allStates) {
            if(state.getStateCode().equals(stateCode)){
                return state;
            }
        }
        return null;
    }

    /**
     * 由具体的状态机定义所有状态
     * @return
     */
    public abstract List<State> declareAllStates();

}
