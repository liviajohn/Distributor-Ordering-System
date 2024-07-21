package org.example.distributororderingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryViewController {

    @FXML
    private Button addToCart;
    @FXML
    private Button Checkout;
    @FXML
    private ImageView backArrow;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> brandColumn;
    @FXML
    private TableColumn<Product, String> sizeColumn;
    @FXML
    private TableColumn<Product, String> productclassColumn;
    @FXML
    private TableColumn<Product, Integer> availableColumn;

    @FXML
    protected void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        productclassColumn.setCellValueFactory(new PropertyValueFactory<>("productClass"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));

        productTableView.setItems(ProductManagement.getProductsAsObservableList());
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
        //Implement checkout functionality
    }

    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/logout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }
}
