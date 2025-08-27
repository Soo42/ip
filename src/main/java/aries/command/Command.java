package aries.command;

import aries.AriesException;
import aries.task.TaskList;
import aries.ui.Ui;

public interface Command {
    boolean execute(TaskList tasks, Ui ui) throws AriesException;
    
    default boolean isExit() {
        return false;
    }
} 
