package com.dag;

public class Task implements Executor {

    /**
     * 任务id
     */
    private Long id;

    /**
     * 任务名
     */
    private String name;

    /**
     * 状态0：未执行
     * 状态1：已执行
     */
    private int state;

    public Task(Long id, String name, int state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    @Override
    public boolean executor() {
        System.out.println("Task id: [" + id + "], " + "task name: [" + name +"] is running");
        state = 1;
        return true;
    }

    /**
     * 判断任务是否已经执行过
     * @return
     */
    public boolean hasExecuted(){
        return state == 1;
    }
}
