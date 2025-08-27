package aries.command;

import aries.AriesException;
import aries.Ui;
import aries.task.Deadline;
import aries.task.Task;
import aries.task.TaskList;

public class DeadlineCommand implements Command {
    private String description;

    public DeadlineCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        if (description == null || description.isEmpty()) {
            throw new AriesException("OOPS!!! The description of a deadline cannot be empty.");
        }

        String[] parts = description.split(" /by ");
        if (parts.length != 2 || parts[0].isEmpty()) {
            throw new AriesException("OOPS!!! The description of a deadline must be in the format: description /by date_time");
        }

        String desc = parts[0].trim();
        String by = parts[1].trim();
        Task t = new Deadline(desc, by);
        tasks.add(t);
        ui.added(tasks);
        return true;
    }
}
