import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream

;

public class Storage {
    private File file;

    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    public TaskList load() {
        if (!file.exists()) {
            return new TaskList();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (TaskList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aries is not able to load now:) " + e.getMessage());
            return new TaskList();
        }
    }

    public void save(TaskList tasks) {
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(tasks);
        } catch (IOException e) {
            throw new RuntimeException("Error saving tasks: " + e.getMessage());
        }
    }
}
