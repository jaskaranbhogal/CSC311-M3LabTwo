package com.example.csc311m3labtwo;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {

    @FXML
    private ProgressBar splashProgress;

    @FXML
    public void initialize() {
        if (splashProgress != null) {
            Platform.runLater(this::runSplash);
        }
    }

    private void runSplash() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(splashProgress.progressProperty(), 0)),
                new KeyFrame(Duration.millis(1600),
                        new KeyValue(splashProgress.progressProperty(), 1))
        );

        timeline.setOnFinished(event -> openLogin());
        timeline.play();
    }

    private void openLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );

            Parent root = loader.load();
            Stage stage = (Stage) splashProgress.getScene().getWindow();
            stage.setScene(new Scene(root, 900, 600));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void openRegistration(ActionEvent event) {
        changeScene("registration.fxml", (Node) event.getSource());
    }

    @FXML
    private void backToLogin(ActionEvent event) {
        changeScene("login.fxml", (Node) event.getSource());
    }

    @FXML
    private void closeApp() {
        Platform.exit();
    }

    private void changeScene(String fileName, Node source) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(fileName)
            );

            Parent root = loader.load();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root, 900, 600));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
