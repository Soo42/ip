package aries.command;

import aries.task.TaskList;
import aries.ui.Ui;

public class ListCommand implements Command {
    @Override
    public boolean execute(TaskList tasks, Ui ui) {
        ui.showTaskList(tasks);
        return false;
    }
    
}
