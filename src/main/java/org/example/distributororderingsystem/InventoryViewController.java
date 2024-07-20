package org.example.distributororderingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InventoryViewController {

    @FXML
    private Text id;
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
    protected void initialize() {
        id.setText(ProductManagement.getIDList());
        // Set other product details as needed
        // Example:
        // Product product = ProductManagement.getProduct(id);
        // productName.setText(product.getName());
        // brandName.setText(product.getBrand());
        // size.setText(product.getSize());
        // productClass.setText(product.getProductClass());
        // amountAvailable.setText(String.valueOf(product.getAvailable()));
    }

    @FXML
    protected void onCheckoutButtonClick() {
        // Implement checkout functionality
    }
    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/logout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }
}
