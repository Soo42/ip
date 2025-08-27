package aries.command;

import aries.AriesException;
import aries.Ui;
import aries.task.TaskList;

public interface Command {
    boolean execute(TaskList tasks, Ui ui) throws AriesException;
    
    default boolean isExit() {
        return false;
    }
} 
