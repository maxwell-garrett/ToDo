package com.example.max.todo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ToDoManager implements Serializable {
    /**
     * Unique ID of ToDoManager
     */
    private UUID id;

    /**
     * Collection of ToDoTasks
     */
    private List<ToDoTask> todos;

    /**
     * instance of ToDoManager
     */
    private static final ToDoManager instance = new ToDoManager();

    /**
     * Constructor to create first ToDoManager
     */
    private ToDoManager() {
        this.id = UUID.randomUUID();
        this.todos = new ArrayList<>();
    }

    /**
     * Return the unique ToDoManager instance
     *
     * @return ToDoManager instance
     */
    public static ToDoManager getInstance() {
        return instance;
    }

    /**
     * Add new ToDoTask t into the list of ToDos stored and sort.
     *
     * @param t ToDoTask
     */
    public void addToDo(ToDoTask t) {
        this.todos.add(t);
        Collections.sort(this.todos);
    }

    /**
     * Return the ToDoTask at the specified index pos.
     *
     * @param pos index of the ToDoTask
     * @return ToDoTask at pos
     */
    public ToDoTask getTask(int pos) {
        return todos.get(pos);
    }

    /**
     * Return the number of items in the todos list
     *
     * @return number of ToDoTasks
     */
    public int getNumberOfTasks() {
        return todos.size();
    }
}
