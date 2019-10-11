package test.vector;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class VectorArithmeticController {

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField ai;
    @FXML
    private TextField aj;
    @FXML
    private TextField ak;
    @FXML
    private TextField bi;
    @FXML
    private TextField bj;
    @FXML
    private TextField bk;
    @FXML
    private Label ri;
    @FXML
    private Label rj;
    @FXML
    private Label rk;
    @FXML
    Button compute;
    @FXML
    Label iLabel;
    @FXML
    Label jLabel;
    @FXML
    Label kLabel;

    public void setUp() {
        comboBox.getItems().addAll("Plus", "Minus", "Cross","Dot");
        comboBox.getSelectionModel().selectFirst();
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue == null|| aj.getText().isEmpty() || ak.getText().isEmpty() || bi.getText().isEmpty() || bj.getText().isEmpty() || bk.getText().isEmpty()) {
                    setResultEmpty();
                } else evaluate(newValue);
            }
        });
        compute.setOnAction(event -> {
            if (ai.getText().isEmpty() || aj.getText().isEmpty() || ak.getText().isEmpty() || bi.getText().isEmpty() || bj.getText().isEmpty() || bk.getText().isEmpty()) {
                setResultEmpty();
            } else evaluate(comboBox.getValue());
        });

    }

    public void setResultEmpty() {
        ri.setText("");
        rj.setText("");
        rk.setText("");
        iLabel.setText("");
        jLabel.setText("");
        kLabel.setText("");
    }
    public void setLabel(){
        iLabel.setText("i + ");
        jLabel.setText("j + ");
        kLabel.setText("k  ");
    }

    public void evaluate(String operation) {
        if (operation.equals("Plus")) {
            ri.setText(Double.toString(Double.parseDouble(ai.getText()) + Double.parseDouble(bi.getText())));
            rj.setText(Double.toString(Double.parseDouble(aj.getText()) + Double.parseDouble(bj.getText())));
            rk.setText(Double.toString(Double.parseDouble(ak.getText()) + Double.parseDouble(bk.getText())));
            setLabel();
        } else if (operation.equals("Minus")) {
            ri.setText(Double.toString(Double.parseDouble(ai.getText()) - Double.parseDouble(bi.getText())));
            rj.setText(Double.toString(Double.parseDouble(aj.getText()) - Double.parseDouble(bj.getText())));
            rk.setText(Double.toString(Double.parseDouble(ak.getText()) - Double.parseDouble(bk.getText())));
            setLabel();
        } else if (operation.equals("Cross")) {
            ri.setText(Double.toString(Double.parseDouble(aj.getText()) * Double.parseDouble(bk.getText()) - Double.parseDouble(bj.getText()) * Double.parseDouble(ak.getText())));
            rj.setText(Double.toString(Double.parseDouble(ak.getText()) * Double.parseDouble(bi.getText()) - Double.parseDouble(ai.getText()) * Double.parseDouble(bk.getText())));
            rk.setText(Double.toString(Double.parseDouble(ai.getText()) * Double.parseDouble(bj.getText()) - Double.parseDouble(bi.getText()) * Double.parseDouble(aj.getText())));
            setLabel();
        }
        else if (operation.equals("Dot")){
            setResultEmpty();
            rj.setText(Double.toString(Double.parseDouble(ai.getText())*Double.parseDouble(bi.getText())+
                    Double.parseDouble(aj.getText())*Double.parseDouble(bj.getText())+
                    Double.parseDouble(ak.getText())*Double.parseDouble(bk.getText())));
        }

    }

    public static Parent load() {
        Parent parent = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VectorArithmeticController.class.getResource("arithmetic.fxml"));
            parent = fxmlLoader.load();
            VectorArithmeticController vectorArithmeticController = fxmlLoader.getController();
            vectorArithmeticController.setUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }


}
