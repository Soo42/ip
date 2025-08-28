package aries;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AriesTest {

    private static final Path STORE = Path.of("data", "aries_tasks.ser");

    @BeforeEach
    void cleanStorage() throws Exception {
        Files.createDirectories(STORE.getParent());
        Files.deleteIfExists(STORE);
    }

    private String run(String script) throws Exception {
        ByteArrayInputStream mockIn =
                new ByteArrayInputStream((script + "\n").getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();

        InputStream origIn = System.in;
        PrintStream origOut = System.out;
        try {
            System.setIn(mockIn);
            System.setOut(new PrintStream(capturedOut, true, StandardCharsets.UTF_8));
            Aries.main(new String[0]);
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
        }
        return capturedOut.toString(StandardCharsets.UTF_8);
    }

    @Test
    void greetTest() throws Exception {
        String out = run("bye");
        assertTrue(out.contains("Hello! I'm Aries."));
    }

    @Test
    void addTest() throws Exception {
        String out = run("todo read book\nbye");
        assertTrue(out.contains("Got it. I've added this task:"));
    }

    @Test
    void printsTodoTest() throws Exception {
        String out = run("todo read book\nbye");
        assertTrue(out.contains("[T] [ ] read book"));
    }

    @Test
    void showsList() throws Exception {
        String out = run("list\nbye");
        assertTrue(out.contains("Here are the tasks in your list:"));
    }

    @Test
    void listsAddedTask() throws Exception {
        String out = run("todo read book\nlist\nbye");
        assertTrue(out.contains("1. [T] [ ] read book"));
    }

    @Test
    void byeTest() throws Exception {
        String out = run("bye");
        assertTrue(out.contains("Bye. Hope to see you again soon!"));
    }
}
