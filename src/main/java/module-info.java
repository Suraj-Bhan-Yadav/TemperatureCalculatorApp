module com.example.temperaturecalculatorapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temperaturecalculatorapp to javafx.fxml;
    exports com.example.temperaturecalculatorapp;
}