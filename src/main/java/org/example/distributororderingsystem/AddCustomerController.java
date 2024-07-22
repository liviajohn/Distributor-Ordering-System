package org.example.distributororderingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class AddCustomerController {

    @FXML
    private TextField accountIdField;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField pointOfContactField;

    @FXML
    protected void onAddButtonClick(ActionEvent event) throws IOException {
        String accountId = accountIdField.getText();
        String companyName = companyNameField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String zipCode = zipCodeField.getText();
        String phoneNumber = phoneNumberField.getText();
        String pointOfContact = pointOfContactField.getText();

        if (!accountId.isEmpty() && !companyName.isEmpty() && !street.isEmpty() && !city.isEmpty() && !state.isEmpty() && !zipCode.isEmpty() && !phoneNumber.isEmpty() && !pointOfContact.isEmpty()) {
            String address = street + ", " + city + ", " + state + " " + zipCode;
            Text newCustomer = new Text(accountId + "\t\t" + companyName + "\t\t" + address);
            OrderFormController.customers.add(newCustomer);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/customer-management-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
        } else {
            // Show an error message if needed
        }
    }

    @FXML
    protected void onCancelButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/customer-management-view.fxml"));
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
