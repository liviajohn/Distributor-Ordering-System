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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerManagementController {

    @FXML
    private ListView<Text> customerListView;
    @FXML
    private TextField searchField;

    private ObservableList<Text> customers;

    @FXML
    public void initialize() {
        customers = OrderFormController.customers;
        customerListView.setItems(customers);

        // Add listener to the search field to filter the customer list
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterCustomers(newValue));
    }

    private void filterCustomers(String filter) {
        ObservableList<Text> filteredList = FXCollections.observableArrayList();
        for (Text customer : customers) {
            if (customer.getText().toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(customer);
            }
        }
        customerListView.setItems(filteredList);
    }

    @FXML
    protected void onAddCustomerButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/add-customer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/dashboard-view.fxml"));
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
