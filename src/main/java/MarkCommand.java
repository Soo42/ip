import java.util.List;

public class MarkCommand implements Command {
    private String index;

    public MarkCommand(String index) {
        this.index = index;
    }

    @Override
    public boolean execute(List<Task> tasks, Ui ui) throws AriesException {
        int index = IndexHandling.getValidIndex(this.index, tasks.size());
        Task taskToMark = tasks.get(index);
        taskToMark.markAsDone();
        ui.marked(taskToMark, true);
        return true;
    }
}
