package aries.task;

import java.time.LocalDateTime;

import aries.util.DateTime;

/**
 * Represents an event task with a description, start time, and end time.
 */
public class Events extends Task {
    private static final long serialVersionUID = 1L;

    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Constructs an Events object with the specified description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from        The start time of the event in string format.
     * @param to          The end time of the event in string format.
     */
    public Events(String description, String from, String to) {
        super(description);
        this.from = DateTime.parse(from);
        this.to = DateTime.parse(to);
    }

    /**
     * Returns a string representation of the event task, including its type, description, start time, and end time.
     *
     * @return A string representation of the event task.
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + DateTime.format(from) + " to: " + DateTime.format(to) + ")";
    }
}
