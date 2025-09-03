package aries.command;

import aries.AriesException;
import aries.task.Task;
import aries.task.TaskList;
import aries.ui.Ui;
import aries.util.IndexHandling;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand implements Command {
    private String index;

    /**
     * Constructs a DeleteCommand with the specified index.
     *
     * @param index The index of the task to be deleted as a string.
     */
    public DeleteCommand(String index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        int index = IndexHandling.getValidIndex(this.index, tasks.size());
        Task taskToDelete = tasks.get(index);
        tasks.remove(index);
        ui.showDeletedString(taskToDelete, tasks);
        return true;
    }
}
