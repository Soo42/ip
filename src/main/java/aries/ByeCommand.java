package aries;

import aries.task.TaskList;

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
