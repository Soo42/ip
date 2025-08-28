package aries.command;

import aries.AriesException;
import aries.task.Events;
import aries.task.Task;
import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents a command to add an event task to the task list.
 */
public class EventCommand implements Command {
    private String description;

    /**
     * Constructs an EventCommand with the specified description.
     *
     * @param description The full description of the event task, including /from and /to.
     */
    public EventCommand(String description) {
        this.description = description;
    }

    /** Executes the event command by adding a new event task to the task list.
     *
     * @param tasks The task list to which the new event will be added.
     * @param ui    The user interface to display messages.
     * @return true, as the task list is modified.
     * @throws AriesException If the description format is invalid.
     */
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
