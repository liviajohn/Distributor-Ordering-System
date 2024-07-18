package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InvalidLoginController {

    @FXML
    private Label messageLabel;

    public void initialize() {
        // Close the window automatically after 5 seconds
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            messageLabel.getScene().getWindow().hide();
        }).start();
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
