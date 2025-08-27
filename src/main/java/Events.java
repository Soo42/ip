import java.time.LocalDateTime;

public class Events extends Task {
    private static final long serialVersionUID = 1L;

    protected LocalDateTime from;
    protected LocalDateTime to;

    public Events(String description, String from, String to) {
        super(description);
        this.from = DateTime.parse(from);
        this.to = DateTime.parse(to);
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + DateTime.format(from) + " to: " + DateTime.format(to) + ")";
    }    
}
