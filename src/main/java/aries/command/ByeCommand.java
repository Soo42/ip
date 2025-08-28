package aries.command;

import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand implements Command {
    /**
     * Executes the bye command, which does not mutate the task list.
     *
     * @param tasks The task list to operate on (not used in this command).
     * @param ui The user interface for interaction (not used in this command).
     * @return false, as this command does not mutate the task list.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui) {
        return false;
    }

    /**
     * Indicates that this command is an exit command.
     *
     * @return true, as this command is an exit command.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
