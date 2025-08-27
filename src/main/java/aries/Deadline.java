package aries;

import java.time.LocalDateTime;

public class Deadline extends Task {
    private static final long serialVersionUID = 1L;

    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.by = DateTime.parse(by);
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + DateTime.format(by) + ")";
    }
}
