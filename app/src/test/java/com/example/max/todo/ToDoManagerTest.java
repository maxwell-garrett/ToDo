package com.example.max.todo;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ToDoManagerTest {
    /**
     * manager of ToDOs
     */
    private ToDoManager manager;

    /**
     * Initialize
     */
    @Before
    public void setUp() {
        this.manager = ToDoManager.getInstance();
    }

    @Test
    public void testOrderOfToDos() {
        LocalDateTime creationTime = LocalDateTime.of(2017, 1, 1, 1, 20);
        LocalDateTime dueTime = LocalDateTime.of(2019, 1, 2, 1, 20);
        ToDoTask t1 = new ToDoTask(dueTime, creationTime, "2", "");
        dueTime = LocalDateTime.of(2019, 1, 3, 1, 20);
        ToDoTask t2 = new ToDoTask(dueTime, creationTime, "3", "");
        dueTime = LocalDateTime.of(2018, 1, 3, 1, 20);
        ToDoTask t3 = new ToDoTask(dueTime, creationTime, "1", "");
        manager.addToDo(t1);
        manager.addToDo(t2);
        manager.addToDo(t3);
        assertEquals(t3, manager.getTask(0));
        assertEquals(t1, manager.getTask(1));
        assertEquals(t2, manager.getTask(2));
    }
}
