package com.example.max.todo;

import java.time.LocalDateTime;

public class ToDoTask implements Comparable<ToDoTask> {
    /**
     * Due date of task
     */
    private LocalDateTime due;

    /**
     * Creation date of task
     */
    private LocalDateTime created;

    /**
     * Task name
     */
    private String name;

    /**
     * Task description
     */
    private String desc;

    /**
     * Initialize ToDoTask object
     *
     * @param due date and time that the task is to be completed by
     * @param created date and time that the task is created
     * @param name task name
     * @param desc task description
     */
    public ToDoTask(LocalDateTime due, LocalDateTime created, String name, String desc) {
        this.due = due;
        this.created = created;
        this.name = name;
        this.desc = desc;
    }

    /**
     * implement comparing of ToDoTask objects
     *
     * @param o other ToDoTask object
     * @return negative int if due before o, 0 if equal, positive int if due after o
     */
    @Override
    public int compareTo(ToDoTask o) {
        return due.compareTo(o.getDue());
    }

    /**
     * Return due instance variable
     *
     * @return due date and time of this ToDoTask object
     */
    public LocalDateTime getDue() {
        return due;
    }

    /**
     * Return created instance variable
     *
     * @return created date and time of this ToDoTask object
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * Return name instance variable
     *
     * @return name of the ToDoTask
     */
    public String getName() {
        return name;
    }

    /**
     * Return desc instance variable
     *
     * @return description of the ToDoTask
     */
    public String getDesc() {
        return desc;
    }
}
