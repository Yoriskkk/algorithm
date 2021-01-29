package com.dag;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Digraph {

    /**
     * 顶点集合
     */
    private Set<Task> tasks;

    /**
     * 任务依赖关系集合，key为一个任务，value为这个的任务的前置任务集合
     * 一个任务执行的前提是它在map中没有以它作为key的entry，或者是它的前置任务集合中的任务都是已执行的状态
     */
    private Map<Task,Set<Task>> map;

    public Digraph() {
        this.tasks = new HashSet<>();
        this.map = new HashMap<>();
    }

    public Digraph(Set<Task> tasks, Map<Task, Set<Task>> map) {
        this.tasks = tasks;
        this.map = map;
    }

    /**
     * 添加边，其实就是给当前传入的task，添加一个前置任务pre
     * 这个task，对应有一个前置任务集合
     * @param task
     * @param prev
     */
    public void addEdge(Task task,Task prev){
        if (!tasks.contains(task) || !tasks.contains(prev)) {
            throw new IllegalArgumentException();
        }
        Set<Task> prevs = map.get(task);
        if (prevs == null) {
            prevs = new HashSet<Task>();
            map.put(task, prevs);
        }
        if (prevs.contains(prev)) {
            throw new IllegalArgumentException();
        }
        prevs.add(prev);
    }

    /**
     * 添加任务，也就是在当前Digraph中的任务集合中添加任务
     * @param task
     */
    public void addTask(Task task) {
        if (tasks.contains(task)) {
            throw new IllegalArgumentException();
        }
        tasks.add(task);
    }

    /**
     * 删除任务的话，其实就是在当前Digraph中的任务集合中删除，并把每个任务的前置任务中也清除掉
     */
    public void remove(Task task) {
        if (!tasks.contains(task)) {
            return;
        }
        if (map.containsKey(task)) {
            map.remove(task);
        }
        for (Set<Task> set : map.values()) {
            if (set.contains(task)) {
                set.remove(task);
            }
        }
    }


}
