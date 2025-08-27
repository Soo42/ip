package aries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    
    public void add(Task t) {
        tasks.add(t);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "No tasks available.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1)).append(". ").append(tasks.get(i).toString
                    ()).append("\n");   
        }

        return sb.toString().trim();
    }
    
}
