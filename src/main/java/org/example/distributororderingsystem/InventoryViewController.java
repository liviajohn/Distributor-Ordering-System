package org.example.distributororderingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InventoryViewController {

    @FXML
    private ListView<Text> productList = new ListView<>();
    @FXML
    private ObservableList<Text> products;
    @FXML
    private Button addToCart;
    @FXML
    private Button Checkout;
    @FXML
    private Button back;

    @FXML
    protected void initialize() {
        products = FXCollections.observableArrayList(ProductManagement.getProductInfo(15));
        productList.setItems(products);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws Exception {
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
