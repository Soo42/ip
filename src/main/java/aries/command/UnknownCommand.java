package aries.command;

import aries.AriesException;
import aries.task.TaskList;
import aries.ui.Ui;

public class UnknownCommand implements Command {
    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        throw new AriesException(" OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
