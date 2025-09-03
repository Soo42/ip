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

    /**
     * Constructor for the Aries application.
     *
     * @param filePath The file path for the storage.
     */
    public Aries() {
        this.ui = new Ui();
        this.storage = new Storage(DEFAULT_FILE_PATH);
        this.tasks = storage.load();
    }

    public String getResponse(String input) {
        try {
            Command command = CommandParser.parse(input);
            CommandResult result = command.execute(tasks, ui);
            boolean hasChanged = result.isChanged();
            boolean isExit = result.isExit();

            if (hasChanged) {
                storage.save(tasks);
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
}
