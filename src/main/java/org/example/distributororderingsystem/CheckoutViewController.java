package org.example.distributororderingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckoutViewController {

    @FXML
    private TableView<Product> cartTableView;

    @FXML
    private TableColumn<Product, String> idColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

    private ObservableList<Product> cartProducts;
    private Cart cart;

    public void setCart(Cart cart) {
        this.cart = cart;
        cartProducts = FXCollections.observableArrayList(cart.getProducts());
        cartTableView.setItems(cartProducts);
    }

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    protected void onPurchaseButtonClick() {
        // Placeholder for purchase action
    }
}