package aries.command;

import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand implements Command {
    @Override
    public boolean execute(TaskList tasks, Ui ui) {
        return false;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
