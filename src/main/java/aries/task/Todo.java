package aries.task;

/**
 * Represents a Todo task.
 */
public class Todo extends Task {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a Todo task with the given description.
     *
     * @param description The description of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the Todo task.
     *
     * @return A string representation of the Todo task.
     */
    @Override
    public String toString() {
        return "[T] " + super.toString();
    }

}
