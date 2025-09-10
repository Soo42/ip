package aries;

import aries.command.Command;
import aries.command.CommandParser;
import aries.command.CommandResult;
import aries.storage.Storage;
import aries.task.TaskList;
import aries.ui.Ui;

/**
 * The main class for the Aries application.
 * It initializes the UI, storage, and task list, and handles the main command loop.
 */
public class Aries {
    private static final String DEFAULT_FILE_PATH = "data/aries_tasks.ser";
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;
    private String commandType;

    /**
     * Constructor for the Aries application.
     *
     * @param filePath The file path for the storage.
     */
    public Aries() {
        this.ui = new Ui();
        this.storage = new Storage(DEFAULT_FILE_PATH);
        this.tasks = storage.loadTaskList();
        try {
            tasks.rebuildKeys();
        } catch (AriesException e) {
            System.out.println("Error rebuilding task keys: " + e.getMessage());
        }
    }

    public String getResponse(String input) {
        try {
            Command command = CommandParser.parse(input);
            CommandResult result = command.execute(tasks, ui);
            boolean hasChanged = result.isChanged();
            boolean isExit = result.isExit();
            commandType = command.getClass().getSimpleName();

            if (hasChanged) {
                storage.saveTaskList(tasks);
            }

            if (isExit) {
                return "Goodbye! Hope to see you again soon!";
            }
            return result.getResponse();
        } catch (AriesException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }

    public String getCommandType() {
        return commandType;
    }

    public String getWelcomeMessage() {
        return ui.showWelcomeMessage();
    }
}
