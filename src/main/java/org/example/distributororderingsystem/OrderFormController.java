package org.example.distributororderingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderFormController {

    @FXML
    private ListView<Text> customerListView;

    @FXML
    private TextField deliveryDateField;

    @FXML
    private ComboBox<String> salesRepIdComboBox;

    @FXML
    private ComboBox<String> deliveryRepIdComboBox;

    @FXML
    private TextField searchField;

    public static ObservableList<Text> customers = FXCollections.observableArrayList();
    private ObservableList<String> salesReps;
    private ObservableList<String> deliveryReps;

    public static String selectedCustomer;
    public static String selectedDeliveryDate;
    public static String selectedSalesRepId;
    public static String selectedDeliveryRepId;

    static {
        // Initialize customers if not already initialized
        if (customers.isEmpty()) {
            customers.addAll(AppInitializer.initializeCustomers());
        }
    }

    @FXML
    public void initialize() {
        customerListView.setItems(customers);

        // Initialize the sales reps list
        salesReps = FXCollections.observableArrayList(
                "John Smith (ID: JSM_12345678)",
                "Sarah Smith (ID: SSM_12345679)",
                "Michael Johnson (ID: MJO_12345680)",
                "Emily Davis (ID: EDA_12345681)",
                "David Wilson (ID: DWI_12345682)",
                "Jessica Garcia (ID: JGA_12345683)",
                "Daniel Martinez (ID: DMA_12345684)",
                "Jennifer Anderson (ID: JAN_12345685)",
                "Paul Thomas (ID: PTH_12345686)",
                "Laura Jackson (ID: LJA_12345687)"
        );

        salesRepIdComboBox.setItems(salesReps);
        salesRepIdComboBox.setEditable(true);

        // Initialize the delivery reps list
        deliveryReps = FXCollections.observableArrayList(
                "John Johnson (ID: JJO_12345678)",
                "Smithy Smithson (ID: SSM_12345679)",
                "Michael Brown (ID: MBR_12345680)",
                "Emily White (ID: EWH_12345681)",
                "David Harris (ID: DHA_12345682)",
                "Jessica Thompson (ID: JTH_12345683)",
                "Daniel Clark (ID: DCL_12345684)",
                "Jennifer Lewis (ID: JLE_12345685)",
                "Paul Walker (ID: PWA_12345686)",
                "Laura King (ID: LKI_12345687)"
        );

        deliveryRepIdComboBox.setItems(deliveryReps);
        deliveryRepIdComboBox.setEditable(true);

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
    protected void onLogoutButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/logout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void onNextButtonClick(ActionEvent event) throws IOException {
        // Check if a customer is selected
        if (customerListView.getSelectionModel().getSelectedItem() == null) {
            // Show an error message or handle the case where no customer is selected
            return;
        }

        // Get the input values
        selectedCustomer = customerListView.getSelectionModel().getSelectedItem().getText();
        selectedDeliveryDate = deliveryDateField.getText();
        selectedSalesRepId = salesRepIdComboBox.getValue();
        selectedDeliveryRepId = deliveryRepIdComboBox.getValue();

        // Validate the input values
        if (selectedDeliveryDate.isEmpty() || selectedSalesRepId.isEmpty() || selectedDeliveryRepId.isEmpty()) {
            // Show an error message or handle the case where input values are not valid
            return;
        }

        // Proceed to the Inventory page
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/inventory-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        // Go back to the Dashboard
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/dashboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }
}
