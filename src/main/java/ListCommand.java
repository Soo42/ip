import java.util.List;

public class ListCommand implements Command {
    @Override
    public boolean execute(List<Task> tasks, Ui ui) {
        ui.showTaskList(tasks);
        return false;
    }
    
}
