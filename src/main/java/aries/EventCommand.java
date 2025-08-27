package aries;

public class EventCommand implements Command {
    private String description;

    public EventCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        if (description == null || description.isEmpty()) {
            throw new AriesException("OOPS!!! The description of an event cannot be empty.");
        }

        int fromIdx = description.indexOf(" /from ");
        int toIdx   = description.indexOf(" /to ");

        if (fromIdx < 0 || toIdx < 0 || toIdx <= fromIdx) {
            throw new AriesException("OOPS!!! The event format should be: event <description> /from <start time> /to <end time>");
        }

        String desc = description.substring(0, fromIdx).trim();
        String from = description.substring(fromIdx + " /from ".length(), toIdx).trim();
        String to   = description.substring(toIdx + " /to ".length()).trim();

        if (desc.isEmpty() || from.isEmpty() || to.isEmpty()) {
            throw new AriesException("OOPS!!! The event format should be: event <description> /from <start time> /to <end time>");
        }

        Task t = new Events(desc, from, to);
        tasks.add(t);
        ui.added(tasks);
        return true;
    }
}
