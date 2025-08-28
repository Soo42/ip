package aries.ui;

import java.util.Scanner;

import aries.task.Task;
import aries.task.TaskList;

/**
 * Ui class handles all interactions with the user.
 * It reads user input and displays messages to the user.
 */
public class Ui {
    private static final String line = "____________________________________";
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Greets the user with a welcome message.
     */
    public void greet() {
        System.out.println(line);
        System.out.println("Hello! I'm Aries.");
        System.out.println("What can I do for you?");
        System.out.println(line);
    }

    /**
     * Bids farewell to the user and closes the scanner.
     */
    public void exit() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
        close();
    }

    /**
     * Reads a line of input from the user.
     *
     * @return The line of input entered by the user.
     */
    public String read() {
        return scanner.nextLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(line);
        System.out.println(message);
        System.out.println(line);
    }

    /**
     * Closes the scanner to prevent resource leaks.
     */
    public void close() {
        scanner.close();
    }

    /**
     * Displays the list of tasks to the user.
     *
     * @param tasks The TaskList containing the tasks to be displayed.
     */
    public void showTaskList(TaskList tasks) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println(line);
    }

    /**
     * Displays a message indicating that a task has been added.
     *
     * @param tasks The TaskList after addition.
     */
    public void added(TaskList tasks) {
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    /**
     * Displays a message indicating that a task has been deleted.
     *
     * @param task  The Task that was deleted.
     * @param tasks The TaskList after deletion.
     */
    public void deleted(Task task, TaskList tasks) {
        System.out.println(line);
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    /**
     * Displays a message indicating that a task has been marked as done or not done.
     *
     * @param task   The Task to be marked.
     * @param isDone A boolean indicating whether the task is marked as done (true) or not done (false).
     */
    public void marked(Task task, boolean isDone) {
        System.out.println(line);
        System.out.println(isDone ? "Nice! I've marked this task as done:" : "OK, I've marked this task as not done yet:");
        System.out.println(task);
        System.out.println(line);
    }

    public void showFoundTasks(TaskList foundTasks) {
        System.out.println(line);
        if (foundTasks.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < foundTasks.size(); i++) {
                System.out.println((i + 1) + ". " + foundTasks.get(i));
            }
        }
        System.out.println(line);
    }
}
