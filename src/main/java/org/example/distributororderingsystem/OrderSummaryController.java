package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderSummaryController {

    @FXML
    private TableView<OrderItem> orderTableView;

    @FXML
    private TableColumn<OrderItem, String> itemColumn;

    @FXML
    private TableColumn<OrderItem, Integer> quantityColumn;

    @FXML
    private TableColumn<OrderItem, Double> costColumn;

    @FXML
    private Label totalCostLabel;

    private List<OrderItem> orderItems;
    private double totalCost;

    @FXML
    public void initialize() {
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        //Replace with actual data when integrated with order entry form
        orderItems = List.of(
                new OrderItem("Item 1", 2, 19.99),
                new OrderItem("Item 2", 1, 9.99),
                new OrderItem("Item 3", 3, 5.99)
        );

        orderTableView.getItems().setAll(orderItems);

        totalCost = orderItems.stream().mapToDouble(item -> item.getQuantity() * item.getCost()).sum();
        totalCostLabel.setText("Total Cost: " + totalCost);
    }

    @FXML
    public void saveOrder() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            saveOrderToFile(file);
        }
    }

    private void saveOrderToFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (OrderItem item : orderItems) {
                writer.write(item.toString() + "\n");
            }
            writer.write("Total Cost: " + totalCost + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class OrderItem {
        private String item;
        private int quantity;
        private double cost;

        public OrderItem(String item, int quantity, double cost) {
            this.item = item;
            this.quantity = quantity;
            this.cost = cost;
        }

        public String getItem() {
            return item;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return item + ": " + quantity + " @ " + cost;
        }
    }
}
