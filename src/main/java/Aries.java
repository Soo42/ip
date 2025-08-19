import java.util.Scanner;

public class Aries {
    public static void main(String[] args) {
        String line = "____________________________________";

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
            }

            // print the input back
            System.out.println(line);
            System.out.println(input);
            System.out.println(line);
        }

        scanner.close();
    }
}