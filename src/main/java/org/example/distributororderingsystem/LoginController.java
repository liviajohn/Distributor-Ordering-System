package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick() throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authenticate(username, password)) {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/dashboard-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
        } else {
            // Show error message
        }
    }

    private boolean authenticate(String username, String password) {
        // Simple authentication for demonstration purposes
        return "admin".equals(username) && "password".equals(password);
    }
}
