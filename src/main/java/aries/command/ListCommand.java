package aries.command;

import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents a command to list all tasks.
 */
public class ListCommand implements Command {
    /**
     * Executes the command to list all tasks.
     *
     * @param tasks The task list to display.
     * @param ui    The user interface to interact with the user.
     * @return false indicating that the task list is not being modified.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui) {
        ui.showTaskList(tasks);
        return false;
    }
    
}
