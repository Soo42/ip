package aries.command;

import aries.AriesException;
import aries.task.Task;
import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents a command to find tasks containing a specific keyword.
 */
public class FindCommand implements Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword.trim();
    }

    @Override
    public CommandResult execute(TaskList tasks, Ui ui) throws AriesException {
        if (keyword.isEmpty()) {
            throw new AriesException("OOPS!!! The keyword for find cannot be empty.");
        }

        TaskList foundTasks = new TaskList();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(keyword)) {
                foundTasks.add(task);
            }
        }

        return new CommandResult(ui.showFoundTasks(foundTasks), false, false);
    }
}
