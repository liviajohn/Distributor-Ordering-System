package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class NewCustomerController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;

    @FXML
    protected void onAddCustomerButtonClick() throws IOException {
        String name = nameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        String customerDetails = "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone;
        FileUtil.writeToFile("customer.txt", customerDetails);
    }
}
