module com.example.demosheshbesh {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demosheshbesh to javafx.fxml;
    exports com.example.demosheshbesh;
}