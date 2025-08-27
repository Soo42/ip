package aries;

import aries.storage.Storage;
import aries.task.TaskList;

public class Aries {
    public static void main(String[] args) {
        Ui Ui = new Ui();
        Storage storage = new Storage("data/aries_tasks.ser");
        TaskList tasks = storage.load();

        // Print welcome message
        Ui.greet();

        while (true) {
            String input = Ui.read();

            try {
                Command command = CommandParser.parse(input);
                boolean hasChanged = command.execute(tasks, Ui);

                if (hasChanged) {
                    storage.save(tasks);
                }

                if (command.isExit()) {
                    Ui.exit();
                    return;
                }
            } catch (AriesException e) {
                Ui.showError(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
