package aries.command;

import aries.AriesException;
import aries.task.Task;
import aries.task.TaskList;
import aries.ui.Ui;
import aries.util.IndexHandling;

/**
 * Marks a task as done.
 */
public class MarkCommand implements Command {
    private String index;

    /**
     * Constructor for MarkCommand.
     *
     * @param index The index of the task to be marked as done.
     */
    public MarkCommand(String index) {
        this.index = index;
    }

    /**
     * Executes the mark command.
     * @param tasks The list of tasks.
     * @param ui The user interface.
     * @return true, as the task list is modified.
     * @throws AriesException If the index is invalid.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui) throws AriesException {
        int index = IndexHandling.getValidIndex(this.index, tasks.size());
        Task taskToMark = tasks.get(index);
        taskToMark.markAsDone();
        ui.marked(taskToMark, true);
        return true;
    }
}
