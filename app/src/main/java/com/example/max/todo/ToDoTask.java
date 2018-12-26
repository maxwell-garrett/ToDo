package com.example.max.todo;

import java.time.LocalDateTime;

public class ToDoTask implements Comparable<ToDoTask> {
    // Completion date
    private LocalDateTime due;

    // Creation date
    private LocalDateTime created;

    // Task name
    private String name;

    // Task desc
    private String desc;

    public ToDoTask(LocalDateTime due, LocalDateTime created, String name, String desc) {
        this.due = due;
        this.created = created;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public int compareTo(ToDoTask o) {
        return due.compareTo(o.getDue());
    }

    public LocalDateTime getDue() {
        return due;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
