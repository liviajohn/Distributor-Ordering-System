package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class NewCustomerController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button backButton;

    @FXML
    protected void onAddCustomerButtonClick() throws IOException {
        String name = nameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        String customerDetails = "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone;
        FileUtil.writeToFile("customer.txt", customerDetails);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/dashboard-view.fxml"));
    Scene scene = new Scene(loader.load());
    Stage stage = (Stage) backButton.getScene().getWindow();
    stage.setScene(scene);
}
}
