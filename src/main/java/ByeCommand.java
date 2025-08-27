import java.util.List;

public class ByeCommand implements Command {
    @Override
    public boolean execute(List<Task> tasks, Ui ui) {
        return false;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
