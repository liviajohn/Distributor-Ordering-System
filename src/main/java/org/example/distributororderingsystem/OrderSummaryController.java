package org.example.distributororderingsystem;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderSummaryController {

    @FXML
    private Label customerNameLabel;

    @FXML
    private Label deliveryDateLabel;

    @FXML
    private Label salesRepIdLabel;

    @FXML
    private Label deliveryRepIdLabel;

    @FXML
    private ListView<String> productListView;

    public void setOrderDetails(String customerName, String deliveryDate, String salesRepId, String deliveryRepId, ObservableList<String> products) {
        customerNameLabel.setText(customerName);
        deliveryDateLabel.setText(deliveryDate);
        salesRepIdLabel.setText(salesRepId);
        deliveryRepIdLabel.setText(deliveryRepId);
        productListView.setItems(products);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        // Go back to the Inventory View
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/inventory-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void onConfirmButtonClick(ActionEvent event) throws IOException {
        // Write order details to a text file
        writeOrderToFile();

        // Confirm the order and proceed to the Order Submitted screen
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/order-submitted-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws IOException {
        // Go to the Logout View
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/logout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    private void writeOrderToFile() {
        String customerName = customerNameLabel.getText();
        String deliveryDate = deliveryDateLabel.getText();
        String salesRepId = salesRepIdLabel.getText();
        String deliveryRepId = deliveryRepIdLabel.getText();
        ObservableList<String> products = productListView.getItems();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order_summary.txt", true))) {
            writer.write("Customer Name: " + customerName);
            writer.newLine();
            writer.write("Delivery Date: " + deliveryDate);
            writer.newLine();
            writer.write("Sales Rep ID: " + salesRepId);
            writer.newLine();
            writer.write("Delivery Rep ID: " + deliveryRepId);
            writer.newLine();
            writer.write("Products:");
            writer.newLine();
            for (String product : products) {
                writer.write(" - " + product);
                writer.newLine();
            }
            writer.write("-----");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
