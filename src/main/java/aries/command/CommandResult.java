package aries.command;

public class CommandResult {
    private final String response;
    private final boolean isChanged;
    private final boolean isExit;

    public CommandResult(String response, boolean isChanged, boolean isExit) {
        this.response = response;
        this.isChanged = isChanged;
        this.isExit = isExit;
    }

    public String getResponse() {
        return response;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public boolean isExit() {
        return isExit;
    }
}
