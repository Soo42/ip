import java.util.List;

public interface Command {
    boolean execute(List<Task> tasks, Ui ui) throws AriesException;
    
    default boolean isExit() {
        return false;
    }
} 
