import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aries {
    public static void main(String[] args) {
        Ui Ui = new Ui();
        List<Task> tasks = new ArrayList<>();

        // Print welcome message
        Ui.greet();

        // Scanner is inspired by ex3 in cs2030s
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            try {
                if (input.isEmpty()) {
                    throw new AriesException("Please enter a command.");
                }

                String[] parts = input.split(" ", 2);
                String command = parts[0];
            
                switch (command.toLowerCase()) {
                    // exit the program
                    case "bye":
                        Ui.exit();
                        scanner.close();
                        return;

                    // print the list of tasks
                    case "list":
                        Ui.showTaskList(tasks);
                        break;

                    // mark a task as done
                    case "mark":
                        Task taskToMark = getTaskByIndex(parts, tasks.size(), tasks);
                        taskToMark.markAsDone();
                        Ui.marked(taskToMark, true);
                        break;

                    // unmark a task
                    case "unmark":
                        Task taskToUnmark = getTaskByIndex(parts, tasks.size(), tasks);
                        taskToUnmark.unmark();
                        Ui.marked(taskToUnmark, false);
                        break;

                    // add todo
                    case "todo":
                        if (parts.length < 2 || parts[1].isEmpty()) {
                            throw new AriesException("OOPS!!! The description of a todo cannot be empty.");
                        }

                        String toDoDesc = parts[1];
                        Task t = new Todo(toDoDesc);
                        tasks.add(t);
                        Ui.added(tasks);
                        break;

                    // add deadline task
                    case "deadline":
                        if (parts.length < 2 || parts[1].isEmpty()) {
                            throw new AriesException("OOPS!!! The description of a deadline cannot be empty.");
                        }

                        String[] ddlParts = parts[1].split(" /by ");
                        if (ddlParts.length < 2) {
                            throw new AriesException("OOPS!!! The deadline format should be: deadline <description> /by <date/time>");
                        }

                        String ddlDesc = ddlParts[0];
                        String ddlBy = ddlParts[1];
                        t = new Deadline(ddlDesc, ddlBy);
                        tasks.add(t);
                        Ui.added(tasks);
                        break;
                    
                    // add event task
                    case "event":
                        if (parts.length < 2 || parts[1].isEmpty()) {
                            throw new AriesException("OOPS!!! The description of an event cannot be empty.");
                        }

                        String[] eventParts = parts[1].split(" /from | /to ");
                        if (eventParts.length < 3) {
                            throw new AriesException("OOPS!!! The event format should be: event <description> /from <start time> /to <end time>");
                        }

                        String eventDesc = eventParts[0];
                        String from = eventParts[1];
                        String to = eventParts[2];
                        t = new Events(eventDesc, from, to);
                        tasks.add(t);
                        Ui.added(tasks);
                        break;

                    // delete a task by index
                    case "delete":
                        Task taskToDelete = getTaskByIndex(parts, tasks.size(), tasks);
                        tasks.remove(taskToDelete);
                        Ui.deleted(taskToDelete, tasks);
                        break;

                    // add the input to the tasks list
                    default:
                        throw new AriesException(" OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (AriesException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private static Task getTaskByIndex(String[] parts, int taskCount, List<Task> tasks) throws AriesException {
        if (parts.length < 2) {
            throw new AriesException("Please specify task number. e.g., mark 1, unmark 2, delete 3");
        }

        if (taskCount == 0) {
            throw new AriesException("No tasks available.");
        }

        int index;
        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new AriesException("Please enter a valid task number.");
        }

        if (index < 0 || index >= taskCount) {
            throw new AriesException("Task number is out of range.");
        }

        return tasks.get(index);
    }
}
