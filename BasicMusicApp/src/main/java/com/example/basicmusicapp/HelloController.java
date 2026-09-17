package com.example.basicmusicapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onPlayButtonClick() {
        welcomeText.setText("Playing...");
    }
}
