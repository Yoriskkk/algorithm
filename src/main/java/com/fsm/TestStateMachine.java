package com.fsm;

import org.junit.Test;

public class TestStateMachine {

    @Test
    public void test() {
        StateMachine sm = new AuditStateMachine();
        State state = sm.execute(AuditStateMachine.StateCodeContents.PENDING, new Event(AuditStateMachine.EventCodeContents.PASS));
    }
}
