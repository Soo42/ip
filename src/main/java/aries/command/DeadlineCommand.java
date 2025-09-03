package aries.command;

import aries.AriesException;
import aries.task.Deadline;
import aries.task.Task;
import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents a command to add a deadline task.
 */
public class DeadlineCommand implements Command {
    private String description;

    /**
     * Constructs a DeadlineCommand with the given description.
     *
     * @param description The description of the deadline task, including the date/time.
     */
    public DeadlineCommand(String description) {
        this.description = description;
    }

    /** Executes the command to add a deadline task to the task list.
     *
     * @param tasks The task list to which the deadline task will be added.
     * @param ui    The user interface for displaying messages.
     * @return true, as the task list is modified.
     * @throws AriesException If there is an error in adding the task.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        if (description == null || description.isEmpty()) {
            throw new AriesException("OOPS!!! The description of a deadline cannot be empty.");
        }

        String[] parts = description.split(" /by ");
        if (parts.length != 2 || parts[0].isEmpty()) {
            throw new AriesException("OOPS!!! The description of a deadline must be in the format: "
                    + "description /by date_time");
        }

        String desc = parts[0].trim();
        String by = parts[1].trim();
        Task t = new Deadline(desc, by);
        tasks.add(t);
        ui.added(tasks);
        return true;
    }
}
