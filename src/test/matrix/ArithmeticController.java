package test.matrix;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;


import java.io.IOException;
import java.util.*;

public class ArithmeticController {


    @FXML
    private Button compute;
    @FXML
    private Label message;
    @FXML
    private Spinner<Integer> row1;
    @FXML
    private Spinner<Integer> column1;
    @FXML
    private Spinner<Integer> row2;
    @FXML
    private Spinner<Integer> column2;
    @FXML
    private GridPane matrixOneInput;
    @FXML
    private GridPane matrixTwoInput;
    @FXML
    private GridPane result;
    @FXML
    private ComboBox<String> operation;
    private int ra, rb, ca, cb;

    private TextField textFielda[][] = null;
    private TextField textFieldb[][] = null;
    private TextField textFieldc[][] = null;

    public void setup(List<String> choice) {

        ra = rb = ca = cb = 2;
        textFielda = new TextField[ra][ca];
        textFieldb = new TextField[rb][cb];

        SpinnerValueFactory.IntegerSpinnerValueFactory row1SpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100);
        SpinnerValueFactory.IntegerSpinnerValueFactory column1SpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100);

        operation.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue=="*"){
                    row2.setValueFactory(column1SpinnerValueFactory);
                    column2.setValueFactory(row1SpinnerValueFactory);
                }
                else {
                    row2.setValueFactory(row1SpinnerValueFactory);
                    column2.setValueFactory(column1SpinnerValueFactory);
                }
            }
        });
        operation.getSelectionModel().select("+");


        compute.setOnAction(event -> {
            if (operation.getValue() == null) message.setText("Choose the operation first");
            else if (operation.getValue().equals("+")) evaluate(1);
            else if (operation.getValue().equals("-")) evaluate(2);
            else if (operation.getValue().equals("*")) evaluate(3);
        });
        matrixOneInput.getColumnConstraints().add(new ColumnConstraints(50));
        matrixTwoInput.getColumnConstraints().add(new ColumnConstraints(50));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                TextField a = new TextField();
                a.setPromptText("a" + i + "" + j);
                textFielda[i][j] = a;
                textFielda[i][j].setAlignment(Pos.CENTER);
                textFielda[i][j].setMinWidth(30);
                textFielda[i][j].setMinHeight(30);
                matrixOneInput.add(textFielda[i][j], j, i);
                matrixOneInput.getColumnConstraints().add(j, new ColumnConstraints(35));
                matrixOneInput.getRowConstraints().add(j, new RowConstraints(35));

                TextField b = new TextField();
                b.setPromptText("b" + i + "" + j);
                textFieldb[i][j] = b;
                textFieldb[i][j].setAlignment(Pos.CENTER);
                textFieldb[i][j].setMinWidth(30);
                textFieldb[i][j].setMinHeight(30);
                matrixTwoInput.add(textFieldb[i][j], j, i);
                matrixTwoInput.getColumnConstraints().add(j, new ColumnConstraints(35));
                matrixTwoInput.getRowConstraints().add(j, new RowConstraints(35));
            }
        }

        operation.getItems().addAll(choice);

        row1.setValueFactory(row1SpinnerValueFactory);
        row1.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = matrixOneInput.getChildren().size();
                matrixOneInput.getChildren().remove(0, x);
                ra = Integer.parseInt(newValue);
                textFielda = new TextField[ra][ca];
                for (int i = 0; i < Integer.parseInt(newValue); i++) {
                    for (int j = 0; j < ca; j++) {
                        setUpMatrix(i, j, textFielda, matrixOneInput);
                    }
                }
            }
        });
        row2.setValueFactory(row1SpinnerValueFactory);
        row2.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = matrixTwoInput.getChildren().size();
                matrixTwoInput.getChildren().remove(0, x);
                rb = Integer.parseInt(newValue);
                textFieldb = new TextField[rb][cb];
                for (int i = 0; i < Integer.parseInt(newValue); i++) {
                    for (int j = 0; j < cb; j++) {
                        setUpMatrix(i, j, textFieldb, matrixTwoInput);
                    }
                }
            }

        });
        column1.setValueFactory(column1SpinnerValueFactory);
        column1.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = matrixOneInput.getChildren().size();
                matrixOneInput.getChildren().remove(0, x);
                ca = Integer.parseInt(newValue);
                textFielda = new TextField[ra][ca];
                for (int i = 0; i < ra; i++) {
                    for (int j = 0; j < Integer.parseInt(newValue); j++) {
                        setUpMatrix(i, j, textFielda, matrixOneInput);
                    }
                }

            }
        });
        column2.setValueFactory(column1SpinnerValueFactory);
        column2.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = matrixTwoInput.getChildren().size();
                matrixTwoInput.getChildren().remove(0, x);
                cb = Integer.parseInt(newValue);
                textFieldb = new TextField[rb][cb];
                for (int i = 0; i < rb; i++) {
                    for (int j = 0; j < Integer.parseInt(newValue); j++) {
                        setUpMatrix(i, j, textFieldb, matrixTwoInput);
                    }
                }
            }
        });

    }

    public static Parent setMatrix(List<String> choice) {
        FXMLLoader fxmlLoader = new FXMLLoader(ArithmeticController.class.getResource("arithmetic.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
            ArithmeticController arithmeticController = fxmlLoader.getController();
            arithmeticController.setup(choice);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void evaluate(int l) {
        ObservableList list = matrixOneInput.getChildren();

        if (l == 1) {
            textFieldc = new TextField[ra][cb];
            for (int i = 0; i < ra; i++) {
                for (int j = 0; j < cb; j++) {
                    setUpMatrix(i, j, textFieldc, result);
                    textFieldc[i][j].setText(Double.toString(Double.parseDouble(textFielda[i][j].getText()) + Double.parseDouble(textFieldb[i][j].getText())));
                }
            }

        } else if (l == 2) {
            textFieldc = new TextField[ra][cb];
            for (int i = 0; i < ra; i++) {
                for (int j = 0; j < cb; j++) {
                    setUpMatrix(i, j, textFieldc, result);
                    textFieldc[i][j].setText(Double.toString(Double.parseDouble(textFielda[i][j].getText()) - Double.parseDouble(textFieldb[i][j].getText())));
                }
            }

        } else if (l == 3) {
            if (ca != rb) message.setText("Please check the size of your matrix");
            textFieldc = new TextField[ra][cb];

            for (int i = 0; i < ra; i++) {
                for (int j = 0; j < cb; j++) {
                    setUpMatrix(i, j, textFieldc, result);
                }
            }
            for (int i = 0; i < ra; i++) {
                for (int j = 0; j < cb; j++) {
                    double temp = 0;
                    for (int k = 0; k < rb; k++) {
                        temp += Double.parseDouble(textFielda[i][k].getText()) * Double.parseDouble(textFieldb[k][j].getText());
                    }
                    textFieldc[i][j] = new TextField();
                    textFieldc[i][j].setText(Double.toString(temp));
                    result.add(textFieldc[i][j], j, i);
                }
            }
        }
    }

    public void setUpMatrix(int i, int j, TextField textFieldd[][], GridPane gridPane) {
        textFieldd[i][j] = new TextField();
        textFieldd[i][j].setMinWidth(35);
        textFieldd[i][j].setMinHeight(35);
        if (textFieldd == textFieldb)
            textFieldd[i][j].setPromptText("b" + i + "" + j);
        else if (textFieldd == textFielda)
            textFieldd[i][j].setPromptText("a" + i + "" + j);

        textFieldd[i][j].setAlignment(Pos.CENTER);
        gridPane.add(textFieldd[i][j], j, i);
        gridPane.getColumnConstraints().add(j, new ColumnConstraints(35));
        gridPane.getRowConstraints().add(j, new RowConstraints(35));
    }
    /*public static void setUpSpinner(Spinner<Integer> spinner,GridPane inputGrid,int row,int column,TextField textArray[][] ){
        spinner.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = inputGrid.getChildren().size();
                inputGrid.getChildren().remove(0, x);

                row = Integer.parseInt(newValue);
                textArray = new TextField[row][column];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < Integer.parseInt(newValue); j++) {
                        setUpMatrix(i, j, textFieldb, matrixTwoInput);
                    }
                }
            }
        });

    }*/
}
