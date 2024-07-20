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

    private ObservableList<Text> customers;
    private ObservableList<String> salesReps;
    private ObservableList<String> deliveryReps;

    @FXML
    public void initialize() {
        // Initialize the customer list
        customers = FXCollections.observableArrayList(
                new Text("VVLTC2OF2UCNDS4\tABC Liquor Store\t1234 Storyside Ln, Atlanta, GA 30305"),
                new Text("MVQHSPNWYTLPL0M\tAce Liquors\t585 Franklin Gateway, Kennesaw, GA 30152"),
                new Text("CLKC5UCM6QCPPVU\tBig A Bottle Shop\t957 South Marietta Pkwy, Atlanta, GA 30303"),
                new Text("1WR5TFK3GOJZY9J\t\tCanton Package\t1769 Canton Rd, Marietta, GA 30249"),
                new Text("439RP63Y5UW5AJ3\t\tCapital City Wine & Spirits\t3101 Cobb Pkwy, Marietta, GA 30018"),
                new Text("57XZZDFFY3F06EP\t\tCiti Wine & Spirits\t2941 Northeast Expy, Kennesaw, GA 30152"),
                new Text("2ZXR9W3DJGKMV8B\tDuluth Liquor Store\t431 Main St, Duluth, GA 30096"),
                new Text("W4ZQ8LMR9BCPY3K\tEagle Liquors\t782 Eagle Dr, Woodstock, GA 30189"),
                new Text("E3V5RT9K2JUZT0G\t\tEast Cobb Liquor Store\t1234 Johnson Ferry Rd, Marietta, GA 30062"),
                new Text("A1B2C3D4E5F6G7H\t\tElite Liquors\t678 Elite Rd, Roswell, GA 30075"),
                new Text("Z3X5C7V8B9N0M1K\tFriendly Liquor Store\t2345 Friendly Ln, Alpharetta, GA 30005"),
                new Text("G6H7J8K9L0M1N2B\tGeorgia Liquor Store\t5678 Georgia St, Norcross, GA 30071"),
                new Text("N8M7B6V5C4X3Z2A\tGrand Liquors\t7890 Grand Ave, Smyrna, GA 30080"),
                new Text("C7B6A5Z4X3V2N1M\tGreen Bottle Shop\t1357 Green St, Decatur, GA 30030"),
                new Text("Y6X5W4V3C2B1N0M\tHeritage Liquor Store\t2468 Heritage Dr, Tucker, GA 30084")
        );

        customerListView.setItems(customers);

        // Initialize the sales reps list
        salesReps = FXCollections.observableArrayList(
                "John Smith (ID: 12345678)",
                "Sarah Smith (ID: 12345679)",
                "Michael Johnson (ID: 12345680)",
                "Emily Davis (ID: 12345681)",
                "David Wilson (ID: 12345682)",
                "Jessica Garcia (ID: 12345683)",
                "Daniel Martinez (ID: 12345684)",
                "Jennifer Anderson (ID: 12345685)",
                "Paul Thomas (ID: 12345686)",
                "Laura Jackson (ID: 12345687)"
        );

        salesRepIdComboBox.setItems(salesReps);
        salesRepIdComboBox.setEditable(true);

        // Initialize the delivery reps list
        deliveryReps = FXCollections.observableArrayList(
                "John Johnson (ID: 12345678)",
                "Smithy Smithson (ID: 12345679)",
                "Michael Brown (ID: 12345680)",
                "Emily White (ID: 12345681)",
                "David Harris (ID: 12345682)",
                "Jessica Thompson (ID: 12345683)",
                "Daniel Clark (ID: 12345684)",
                "Jennifer Lewis (ID: 12345685)",
                "Paul Walker (ID: 12345686)",
                "Laura King (ID: 12345687)"
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
    protected void onNextButtonClick(ActionEvent event) throws Exception {
        // Check if a customer is selected
        if (customerListView.getSelectionModel().getSelectedItem() == null) {
            // Show an error message or handle the case where no customer is selected
            return;
        }

        // Get the input values
        String deliveryDate = deliveryDateField.getText();
        String salesRepId = salesRepIdComboBox.getValue();
        String deliveryRepId = deliveryRepIdComboBox.getValue();

        // Validate the input values
        if (deliveryDate.isEmpty() || salesRepId.isEmpty() || deliveryRepId.isEmpty()) {
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
    protected void onBackButtonClick(ActionEvent event) throws Exception {
        // Go back to the Dashboard
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/dashboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }
}
