package aries;

public interface Command {
    boolean execute(TaskList tasks, Ui ui) throws AriesException;
    
    default boolean isExit() {
        return false;
    }
} 
