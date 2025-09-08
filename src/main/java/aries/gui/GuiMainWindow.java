package aries.gui;

import aries.Aries;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class GuiMainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Aries aries;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/mrbean.png"));
    private Image ariesImage = new Image(this.getClass().getResourceAsStream("/images/spongebob.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Aries instance */
    public void setAries(Aries aries) {
        this.aries = aries;
        dialogContainer.getChildren().add(
                DialogBox.getAriesDialog(aries.getWelcomeMessage(), ariesImage, ""));
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing
     * Aries's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = aries.getResponse(input);
        String commandType = aries.getCommandType();
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getAriesDialog(response, ariesImage, commandType));
        userInput.clear();
    }
}
