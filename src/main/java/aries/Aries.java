package aries;

import aries.command.Command;
import aries.command.CommandParser;
import aries.storage.Storage;
import aries.task.TaskList;
import aries.ui.Ui;

/**
 * The main class for the Aries application.
 * It initializes the UI, storage, and task list, and handles the main command loop.
 */
public class Aries {
    /**
     * The entry point of the Aries application.
     * It initializes the UI, storage, and task list, and enters the main command loop.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage("data/aries_tasks.ser");
        TaskList tasks = storage.load();

        // Print welcome message
        ui.greet();

        while (true) {
            String input = ui.readInputString();

            try {
                Command command = CommandParser.parse(input);
                boolean hasChanged = command.execute(tasks, ui);

                if (hasChanged) {
                    storage.save(tasks);
                }

                if (command.isExit()) {
                    ui.exit();
                    return;
                }
            } catch (AriesException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
