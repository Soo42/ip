package aries.command;

import aries.AriesException;
import aries.Ui;
import aries.task.Task;
import aries.task.TaskList;
import aries.task.Todo;

public class ToDoCommand implements Command {
    private String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        if (description == null || description.isEmpty()) {
            throw new AriesException("OOPS!!! The description of a todo cannot be empty.");
        }

        Task t = new Todo(description);
        tasks.add(t);
        ui.added(tasks);
        return true;
    }
}
