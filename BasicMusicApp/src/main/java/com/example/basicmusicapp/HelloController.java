package com.example.basicmusicapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.io.File;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Player player;

    @FXML
    protected void onChooseMusicClick(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        Button button = (Button) event.getSource();
        File selectedFile = chooser.showOpenDialog(button.getScene().getWindow());
        if (selectedFile != null) {
            if (player != null) {
                player.close();
            }
            Thread thread = new Thread(() -> {
                try (FileInputStream inputStream = new FileInputStream(selectedFile)){

                    player = new Player(inputStream);
                    player.play();
                } catch (IOException | JavaLayerException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    @FXML
    protected void onStopClick() {
        if (player != null) {
            player.close();
            player = null;
        }
    }
}
