package com.fsm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 状态节点，如待审批、审批通过、审批拒绝
 */
@Data
@Slf4j
public class State {

    /** 状态码 **/
    private String stateCode;

    /** 当前状态下可允许执行的动作 **/
    private List<Transition> transitions = new ArrayList<>();

    public State(String stateCode, Transition... transitions) {
        this.stateCode = stateCode;
        for (Transition transition : transitions) {
            this.transitions.add(transition);
        }
    }

    /** 添加动作 **/
    public void addTransition(Transition transition){
        transitions.add(transition);
    }

    @Override
    public String toString() {
        return "State{" +
                "stateCode='" + stateCode + '\'' +
                '}';
    }
}
