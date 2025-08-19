import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aries {
    public static void main(String[] args) {
        String line = "____________________________________";
        List<Task> tasks = new ArrayList<>();

        System.out.println(line);
        System.out.println("Hello! I'm Aries.");
        System.out.println("What can I do for you?");
        System.out.println(line);

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
                        System.out.println(line);
                        System.out.println("Bye. Hope to see you again soon!");
                        System.out.println(line);
                        scanner.close();
                        return;

                    // print the list of tasks
                    case "list":
                        System.out.println(line);
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        System.out.println(line);
                        break;

                    // mark a task as done
                    case "mark":
                        Task taskToMark = getTaskByIndex(parts, tasks.size(), tasks);
                        taskToMark.markAsDone();
                        System.out.println(line);
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(taskToMark);
                        System.out.println(line);
                        break;

                    // unmark a task
                    case "unmark":
                        Task taskToUnmark = getTaskByIndex(parts, tasks.size(), tasks);
                        taskToUnmark.unmark();
                        System.out.println(line);
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println(taskToUnmark);
                        System.out.println(line);
                        break;

                    // add todo
                    case "todo":
                        if (parts.length < 2 || parts[1].isEmpty()) {
                            throw new AriesException("OOPS!!! The description of a todo cannot be empty.");
                        }

                        String toDoDesc = parts[1];
                        Task t = new Todo(toDoDesc);
                        tasks.add(t);
                        System.out.println(line);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(tasks.size() - 1));
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println(line);
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
                        System.out.println(line);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(tasks.size() - 1));
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println(line);
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
                        System.out.println(line);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(tasks.get(tasks.size() - 1));
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println(line);
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
            throw new AriesException("Please specify task number. e.g., mark 1");
        }

        if (taskCount == 0) {
            throw new AriesException("No tasks available to mark.");
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
