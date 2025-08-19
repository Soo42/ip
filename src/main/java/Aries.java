import java.util.Scanner;

public class Aries {
    public static void main(String[] args) {
        String line = "____________________________________";
        Task[] tasks = new Task[100];
        int taskCount = 0;

        System.out.println(line);
        System.out.println("Hello! I'm Aries.");
        System.out.println("What can I do for you?");
        System.out.println(line);

        // Scanner is inspired by ex3 in cs2030s
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            // break the loop only when user inputs "bye"
            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(line);
                break;
            } else if (input.equals("list")) {
                // print the list of tasks
                System.out.println(line);
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println(line);
            } else {
                // add the input to the tasks list
                tasks[taskCount++] = new Task(input);

                System.out.println(line);
                System.out.println("added: " + input);
                System.out.println(line);
            }
        }

        scanner.close();
    }
}