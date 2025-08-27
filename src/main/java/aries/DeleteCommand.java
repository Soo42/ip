package aries;

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
