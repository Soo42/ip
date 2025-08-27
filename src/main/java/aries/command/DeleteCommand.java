package aries.command;

import aries.AriesException;
import aries.task.Task;
import aries.task.TaskList;
import aries.ui.Ui;
import aries.util.IndexHandling;

public class DeleteCommand implements Command {
    private String index;

    public DeleteCommand(String index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        int index = IndexHandling.getValidIndex(this.index, tasks.size());
        Task taskToDelete = tasks.get(index);
        tasks.remove(index);
        ui.deleted(taskToDelete, tasks);
        return true;
    }
}
