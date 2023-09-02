package com.example.bmi_cal;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class HelloController {
    @FXML

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginToDashBoard(ActionEvent event) throws IOException {

        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}