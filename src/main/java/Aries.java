import java.util.Scanner;

public class Aries {
    public static void main(String[] args) {
        Ui Ui = new Ui();
        Storage storage = new Storage("data/aries_tasks.ser");
        TaskList tasks = storage.load();

        // Print welcome message
        Ui.greet();

        // Scanner is inspired by ex3 in cs2030s
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            try {
                Command command = CommandParser.parse(input);
                boolean hasChanged = command.execute(tasks, Ui);

                if (hasChanged) {
                    storage.save(tasks);
                }

                if (command.isExit()) {
                    Ui.exit();
                    scanner.close();
                    return;
                }
            } catch (AriesException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
