package com.example.bmi_cal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;

public class dashboard {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField InputWeight;

    @FXML
    private TextField InputHeight;

    @FXML
    private Label answer;
    @FXML
    public void backtologin(ActionEvent event) throws IOException {

        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

        InputHeight.setText("");
        InputWeight.setText("");
    }

    @FXML
    private void calculateBMI() {

        String Weight=InputWeight.getText();
        String Height=InputHeight.getText();

        if(Weight.isEmpty() || Height.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Please Fil The All Fields");
            alert.showAndWait();
            InputHeight.setText("");
            InputWeight.setText("");
        }
        else {
            try{
                double value1 = Double.parseDouble(Weight);
                double value2 = Double.parseDouble(Height);
                double heightmeater=value2/100.0;

               // System.out.println(heightmeater);
               // System.out.println(value1);
                    double ans=(value1)/(heightmeater*heightmeater);

                    String text = Double.toString(ans);
                    if(ans<18.5)
                    {
                        answer.setText("UnderWeight: "+text);
                    }
                    else if(ans>=18.5 && ans<=24.9){
                        answer.setText("Normal: "+text);
                    }
                    else if(ans>=25 && ans<=29.9){
                        answer.setText("OverWeight: "+text);
                    }
                    else{
                        answer.setText("Obese: "+text);
                    }
            }
            catch (NumberFormatException exception){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Please Enter Valid Inputs");
                alert.showAndWait();
                InputHeight.setText("");
                InputWeight.setText("");
            }
        }
    }
    @FXML
    private void clearTextFields() {

        InputHeight.setText("");
        InputWeight.setText("");
        answer.setText("Result");
    }

}
