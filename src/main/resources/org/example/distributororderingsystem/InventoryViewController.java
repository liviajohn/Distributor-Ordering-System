package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import static org.example.distributororderingsystem.ProductManagement.*;

public class InventoryViewController {
    @FXML
    private Text id = new Text(getIDList());
    @FXML
    private Text productName;
    @FXML
    private Text brandName;
    @FXML
    private Text size;
    @FXML
    private Text productClass;
    @FXML
    private Text amountAvailable;
    @FXML
    private Button addToCart;
    @FXML
    private Button Checkout;

    @FXML
    protected void onCheckoutButtonClick() {}
}
