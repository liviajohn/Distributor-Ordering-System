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

public class OrderFormController {

    @FXML
    private ListView<Text> customerListView;


    @FXML
    private TextField deliveryDateField;

    @FXML
    private TextField salesRepIdField;

    @FXML
    private TextField deliveryRepIdField;

    @FXML
    private TextField searchField;

    private ObservableList<Text> customers;

    @FXML
    public void initialize() {
        // Initialize the customer list
        customers = FXCollections.observableArrayList(
                new Text("VVLTC2OF2UCNDS4\tABC Liquor Store\t1234 Storyside Ln, Atlanta, GA 30305"),
                new Text("MVQHSPNWYTLPL0M\tAce Liquors\t585 Franklin Gateway, Kennesaw, GA 30152"),
                new Text("CLKC5UCM6QCPPVU\tBig A Bottle Shop\t957 South Marietta Pkwy, Atlanta, GA 30303"),
                new Text("1WR5TFK3GOJZY9J\tCanton Package\t1769 Canton Rd, Marietta, GA 30249"),
                new Text("439RP63Y5UW5AJ3\tCapital City Wine & Spirits\t3101 Cobb Pkwy, Marietta, GA 30018"),
                new Text("57XZZDFFY3F06EP\tCiti Wine & Spirits\t2941 Northeast Expy, Kennesaw, GA 30152"),
                new Text("2ZXR9W3DJGKMV8B\tDuluth Liquor Store\t431 Main St, Duluth, GA 30096"),
                new Text("W4ZQ8LMR9BCPY3K\tEagle Liquors\t782 Eagle Dr, Woodstock, GA 30189"),
                new Text("E3V5RT9K2JUZT0G\tEast Cobb Liquor Store\t1234 Johnson Ferry Rd, Marietta, GA 30062"),
                new Text("A1B2C3D4E5F6G7H\tElite Liquors\t678 Elite Rd, Roswell, GA 30075"),
                new Text("Z3X5C7V8B9N0M1K\tFriendly Liquor Store\t2345 Friendly Ln, Alpharetta, GA 30005"),
                new Text("G6H7J8K9L0M1N2B\tGeorgia Liquor Store\t5678 Georgia St, Norcross, GA 30071"),
                new Text("N8M7B6V5C4X3Z2A\tGrand Liquors\t7890 Grand Ave, Smyrna, GA 30080"),
                new Text("C7B6A5Z4X3V2N1M\tGreen Bottle Shop\t1357 Green St, Decatur, GA 30030"),
                new Text("Y6X5W4V3C2B1N0M\tHeritage Liquor Store\t2468 Heritage Dr, Tucker, GA 30084")
        );

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
    protected void onNextButtonClick(ActionEvent event) throws Exception {
        // Check if a customer is selected
        if (customerListView.getSelectionModel().getSelectedItem() == null) {
            // Show an error message or handle the case where no customer is selected
            return;
        }

        // Get the input values

        String deliveryDate = deliveryDateField.getText();
        String salesRepId = salesRepIdField.getText();
        String deliveryRepId = deliveryRepIdField.getText();

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
}

