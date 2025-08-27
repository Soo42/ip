public class Ui {
    private static final String line = "____________________________________";

    public void greet() {
        System.out.println(line);
        System.out.println("Hello! I'm Aries.");
        System.out.println("What can I do for you?");
        System.out.println(line);
    }

    public void exit() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line);
    }

    public void showTaskList(TaskList tasks) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println(line);
    }

    public void added(TaskList tasks) {
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    public void deleted(Task task, TaskList tasks) {
        System.out.println(line);
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(line);
    }

    public void marked(Task task, boolean isDone) {
        System.out.println(line);
        System.out.println(isDone ? "Nice! I've marked this task as done:" : "OK, I've marked this task as not done yet:");
        System.out.println(task);
        System.out.println(line);
    }
}
