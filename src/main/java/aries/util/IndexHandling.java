package aries.util;

import aries.AriesException;

public class IndexHandling {
    public static int getValidIndex(String number, int taskCount) throws AriesException {
        if (number == null || number.isEmpty()) {
            throw new AriesException("Please specify task number. e.g., mark 1, unmark 2, delete 3");
        }

        if (taskCount <= 0) {
            throw new AriesException("No tasks available.");
        }

        int index;
        try {
            index = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new AriesException("Please enter a valid task number.");
        }

        if (index < 1 || index > taskCount) {
            throw new AriesException("Task number out of range.");
        }

        return index - 1;
    }
}
