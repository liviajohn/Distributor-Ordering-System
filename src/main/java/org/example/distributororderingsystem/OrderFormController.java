package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class OrderFormController {
    @FXML
    private ComboBox<String> itemComboBox;
    @FXML
    private TextField quantityField;

    @FXML
    protected void onSubmitOrderButtonClick() throws IOException {
        String item = itemComboBox.getValue();
        String quantity = quantityField.getText();

        String orderDetails = "Item: " + item + "\nQuantity: " + quantity;
        FileUtil.writeToFile("order.txt", orderDetails);
    }
}
