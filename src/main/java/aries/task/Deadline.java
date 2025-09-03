package aries.task;

import java.time.LocalDateTime;

import aries.util.DateTime;

/**
 * Represents a deadline task with a description and a due date/time.
 */
public class Deadline extends Task {
    private static final long serialVersionUID = 1L;

    protected LocalDateTime by;

    /**
     * Constructs a Deadline task with the given description and due date/time.
     *
     * @param description The description of the deadline task.
     * @param by The due date/time in string format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = DateTime.parse(by);
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + DateTime.format(by) + ")";
    }
}
