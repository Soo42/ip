package aries.command;

import aries.AriesException;
import aries.task.TaskList;
import aries.ui.Ui;

/**
 * Represents an unknown command.
 */
public class UnknownCommand implements Command {
    /**
     * Executes the unknown command.
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @return never returns normally.
     * @throws AriesException Always thrown to indicate an unknown command.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        throw new AriesException(" OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
