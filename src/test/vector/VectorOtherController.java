package test.vector;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class VectorOtherController {
    @FXML
    private Button compute;
    @FXML
    private TextField i;
    @FXML
    private TextField j;
    @FXML
    private TextField k;
    @FXML
    private Label resulti;
    @FXML
    private Label resultj;
    @FXML
    private Label resultk;

    public void setup(int l) {
        if (l == 1) {
            compute.setOnAction(event -> {
                double magnitude = magnitude(Double.parseDouble(i.getText()), Double.parseDouble(j.getText()), Double.parseDouble(k.getText()));
                resulti.setText(Double.toString(Double.parseDouble(i.getText()) / magnitude));
                resultj.setText(Double.toString(Double.parseDouble(j.getText()) / magnitude));
                resultk.setText(Double.toString(Double.parseDouble(k.getText()) / magnitude));
            });
        } else if (l == 2) {
            compute.setOnAction(event -> resultj.setText(Double.toString(magnitude(Double.parseDouble(i.getText()), Double.parseDouble(j.getText()), Double.parseDouble(k.getText())))));
        } else if (l == 3) {
            compute.setOnAction(event -> {
                resulti.setText(Double.toString(Math.atan(Double.parseDouble(k.getText()) / Double.parseDouble(i.getText()))));
                resultj.setText(Double.toString(Math.atan(Double.parseDouble(k.getText()) / Double.parseDouble(j.getText()))));
                resultk.setText(Double.toString(Math.atan(Double.parseDouble(i.getText()) / Double.parseDouble(k.getText()))));
            });
        }
    }

    public static double magnitude(double i, double j, double k) {

        return Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2));
    }

    public static Parent load(int i) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VectorOtherController.class.getResource("others.fxml"));
            Parent parent = fxmlLoader.load();
            VectorOtherController vectorOtherController = fxmlLoader.getController();
            vectorOtherController.setup(i);
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
