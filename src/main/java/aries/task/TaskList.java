package aries.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks.
 */
public class TaskList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        assert tasks == null : "Task list should be null before initialization.";
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     *
     * @param t The task to be added.
     */
    public void addTask(Task t) {
        assert t != null : "Task cannot be null";
        int sizeBeforeAdd = tasks.size();
        tasks.add(t);
        assert tasks.size() == sizeBeforeAdd + 1 : "Task list size should increase by 1 after adding a task";
    }

    /**
     * Removes a task from the list by its index.
     *
     * @param index The index of the task to be removed.
     */
    public void removeTask(int index) {
        assert index >= 0 && index < tasks.size() : "Index out of bounds";
        int sizeBeforeRemove = tasks.size();
        tasks.remove(index);
        assert tasks.size() == sizeBeforeRemove - 1 : "Task list size should decrease by 1 after removing a task";
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Retrieves a task by its index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     */
    public Task get(int index) {
        assert index >= 0 && index < tasks.size() : "Index out of bounds";
        return tasks.get(index);
    }

    /**
     * Checks if the task list is empty.
     *
     * @return true if the task list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "No tasks available.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1)).append(". ").append(tasks.get(i).toString()).append("\n");
        }

        return sb.toString().trim();
    }

}
