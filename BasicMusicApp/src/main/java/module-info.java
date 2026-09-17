module com.example.basicmusicapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.basicmusicapp to javafx.fxml;
    exports com.example.basicmusicapp;
}