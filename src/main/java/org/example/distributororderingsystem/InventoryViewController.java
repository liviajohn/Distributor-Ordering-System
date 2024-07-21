package org.example.distributororderingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
    private ImageView backArrow;

    @FXML
    protected void initialize() {
        id.setText(ProductManagement.getIDList(15));
        productName.setText(ProductManagement.getNameList(15));
        brandName.setText(ProductManagement.getBrandList(15));
        size.setText(ProductManagement.getSizeList(15));
        productClass.setText(ProductManagement.getClassList(15));
        amountAvailable.setText(ProductManagement.getAvailableList(15));
    }

    @FXML
    protected void onBackArrowClick(ActionEvent event) throws Exception {
        // Go back to the Order Form
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/order-form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
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
