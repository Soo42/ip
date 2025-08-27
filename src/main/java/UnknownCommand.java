import java.util.List;

public class UnknownCommand implements Command {
    @Override
    public boolean execute(List<Task> tasks, Ui ui) throws AriesException {
        throw new AriesException(" OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
