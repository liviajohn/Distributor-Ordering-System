package org.example.distributororderingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InventoryViewController {

    @FXML
    private ListView<String> productListView;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField searchField;

    private ObservableList<String> products;
    private ObservableList<String> filteredProducts;
    private ObservableList<String> selectedProducts = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        products = FXCollections.observableArrayList();
        filteredProducts = FXCollections.observableArrayList();
        loadProductsFromFile("src/main/java/org/example/distributororderingsystem/Products.txt");
        productListView.setItems(filteredProducts);

        // Add listener to the search field to filter the product list
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterProducts(newValue));
    }

    private void loadProductsFromFile(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length == 10) {
                    products.add(parts[1] + "\t" + parts[2] + "\t" + parts[3] + "\t" + parts[4] + "\t" + parts[5]);
                }
            }
            scanner.close();
            filteredProducts.setAll(products); // Initialize the filtered list with all products
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void filterProducts(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredProducts.setAll(products);
        } else {
            ObservableList<String> filteredList = FXCollections.observableArrayList();
            for (String product : products) {
                if (product.toLowerCase().contains(filter.toLowerCase())) {
                    filteredList.add(product);
                }
            }
            filteredProducts.setAll(filteredList);
        }
    }

    @FXML
    protected void onAddToCartButtonClick(ActionEvent event) {
        String selectedProduct = productListView.getSelectionModel().getSelectedItem();
        String quantity = quantityField.getText();

        if (selectedProduct != null && !quantity.isEmpty()) {
            selectedProducts.add(selectedProduct + " - Quantity: " + quantity);
            System.out.println("Added to cart: " + selectedProduct + " - Quantity: " + quantity);
        } else {
            // Show an error message
            System.out.println("Please select a product and enter a quantity.");
        }
    }

    @FXML
    protected void onDoneButtonClick(ActionEvent event) throws IOException {
        // Proceed to the Order Summary page
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/order-summary-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        OrderSummaryController controller = fxmlLoader.getController();

        // Pass the order details to the OrderSummaryController
        controller.setOrderDetails(
                OrderFormController.selectedCustomer,
                OrderFormController.selectedDeliveryDate,
                OrderFormController.selectedSalesRepId,
                OrderFormController.selectedDeliveryRepId,
                selectedProducts
        );

        stage.setScene(scene);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/order-form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/logout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }
}
