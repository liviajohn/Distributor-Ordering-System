package org.example.distributororderingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load products from file
        ProductManagement productManagement = new ProductManagement();
        productManagement.addData("src/main/resources/Products.txt");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/distributororderingsystem/login-view.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        primaryStage.setTitle("Distributor Ordering System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
