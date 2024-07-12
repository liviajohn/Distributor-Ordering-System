module org.example.distributororderingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.distributororderingsystem to javafx.fxml;
    exports org.example.distributororderingsystem;
}