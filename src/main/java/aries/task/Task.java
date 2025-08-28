package aries.task;

import java.io.Serializable;

/**
 * Represents a task with a description and completion status.
 */
public abstract class Task implements Serializable{
    private static final long serialVersionUID = 1L;

    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with the given description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "X" if the task is done, otherwise a space " ".
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Unmarks the task as not done.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }
}
