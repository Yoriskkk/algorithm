package com.fsm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 事件：同意或拒绝
 * 维护事件编码，以及事件附属的业务参数信息
 */
@Data
@Slf4j
public class Event {

    /** 事件编码 **/
    private String eventCode;

    /** 附属的业务参数 **/
    private Map<Object,Object> attributes = null;

    public Event(String eventCode) {
        this.eventCode = eventCode;
    }

    public Event(String eventCode, Map<Object, Object> attributes) {
        this.eventCode = eventCode;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventCode='" + eventCode + '\'' +
                '}';
    }
}
