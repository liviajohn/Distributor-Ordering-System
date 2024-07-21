package org.example.distributororderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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

        // Example data, replace with actual data when integrated with order entry form

        costColumn.prefWidthProperty().bind(
                orderTableView.widthProperty()
                        .subtract(itemColumn.widthProperty())
                        .subtract(quantityColumn.widthProperty())
                        .subtract(2)  // Adjustment for the vertical scrollbar width
        );

        orderItems = List.of(
                new OrderItem("Item 1", 2, 19.99),
                new OrderItem("Item 2", 1, 9.99),
                new OrderItem("Item 3", 3, 5.99)
        );

        orderTableView.getItems().setAll(orderItems);

        totalCost = orderItems.stream().mapToDouble(item -> item.getQuantity() * item.getCost()).sum();
        totalCostLabel.setText("Total Cost: $" + String.format("%.2f", totalCost));
    }

    @FXML
    public void saveAsText() {
        File file = showSaveDialog("Text Files", "*.txt");
        if (file != null) {
            StringBuilder content = new StringBuilder();
            for (OrderItem item : orderItems) {
                content.append(item.toString()).append("\n");
            }
            content.append("Total Cost: $").append(String.format("%.2f", totalCost)).append("\n");
            try {
                FileUtil.writeToFile(file.getAbsolutePath(), content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void saveAsJson() {
        File file = showSaveDialog("JSON Files", "*.json");
        if (file != null) {
            StringBuilder content = new StringBuilder();
            content.append("{\n");
            content.append("\"orderItems\": [\n");
            for (int i = 0; i < orderItems.size(); i++) {
                OrderItem item = orderItems.get(i);
                content.append("  {\n");
                content.append("    \"item\": \"").append(item.getItem()).append("\",\n");
                content.append("    \"quantity\": ").append(item.getQuantity()).append(",\n");
                content.append("    \"cost\": ").append(item.getCost()).append("\n");
                content.append("  }").append(i < orderItems.size() - 1 ? "," : "").append("\n");
            }
            content.append("],\n");
            content.append("\"totalCost\": ").append(totalCost).append("\n");
            content.append("}\n");
            try {
                FileUtil.writeToFile(file.getAbsolutePath(), content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void saveAsXml() {
        File file = showSaveDialog("XML Files", "*.xml");
        if (file != null) {
            StringBuilder content = new StringBuilder();
            content.append("<order>\n");
            for (OrderItem item : orderItems) {
                content.append("  <item>\n");
                content.append("    <name>").append(item.getItem()).append("</name>\n");
                content.append("    <quantity>").append(item.getQuantity()).append("</quantity>\n");
                content.append("    <cost>").append(item.getCost()).append("</cost>\n");
                content.append("  </item>\n");
            }
            content.append("  <totalCost>").append(totalCost).append("</totalCost>\n");
            content.append("</order>\n");
            try {
                FileUtil.writeToFile(file.getAbsolutePath(), content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File showSaveDialog(String description, String extension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(description, extension));
        return fileChooser.showSaveDialog(new Stage());
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
            return item + ": " + quantity + " @ $" + String.format("%.2f", cost);
        }
    }
}
