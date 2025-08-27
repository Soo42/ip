import java.util.List;

public class UnmarkCommand implements Command {
    private String index;

    public UnmarkCommand(String index) {
        this.index = index;
    }

    @Override
    public boolean execute(List<Task> tasks, Ui ui) throws AriesException {
        int index = IndexHandling.getValidIndex(this.index, tasks.size());
        Task taskToUnmark = tasks.get(index);
        taskToUnmark.unmark();
        ui.marked(taskToUnmark, false);
        return true;
    }
}
