package test.matrix;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


import java.io.IOException;

public class OthersController {
    @FXML
    private Spinner<Integer> rowInput;
    @FXML
    private Spinner<Integer> columnInput;
    @FXML
    private GridPane inputGrid;
    @FXML
    private GridPane outputGrid;
    @FXML
    private Label message;
    @FXML
    private Button button;

    private TextField[][] inputArray;
    private TextField[][] resultArray;
    private int row = 2;
    private int column = 2;
    boolean checker = false;
    public void setUp(int k) {

        SpinnerValueFactory.IntegerSpinnerValueFactory rowSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100);
        SpinnerValueFactory.IntegerSpinnerValueFactory columnSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100);

        inputArray = new TextField[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                inputArray[i][j] = new TextField();
                inputArray[i][j].setPromptText("a" + i + "" + j);
                inputGrid.add(inputArray[i][j], j, i);
                inputArray[i][j].setAlignment(Pos.CENTER);
                inputGrid.getColumnConstraints().add(j, new ColumnConstraints(35));
                inputGrid.getRowConstraints().add(j, new RowConstraints(35));
                inputArray[i][j].setMinWidth(35);
                inputArray[i][j].setMinHeight(35);
            }
        }

        rowInput.setValueFactory(rowSpinnerValueFactory);
        rowInput.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = inputGrid.getChildren().size();
                inputGrid.getChildren().remove(0, x);
                row = Integer.parseInt(newValue);
                inputArray = new TextField[row][column];

                for (int i = 0; i < Integer.parseInt(newValue); i++) {
                    for (int j = 0; j < column; j++) {
                        inputArray[i][j] = new TextField();
                        inputGrid.add(inputArray[i][j], j, i);
                        inputArray[i][j].setPromptText("a" + i + "" + j);
                        inputArray[i][j].setAlignment(Pos.CENTER);
                        inputGrid.getColumnConstraints().add(j, new ColumnConstraints(35));
                        inputGrid.getRowConstraints().add(j, new RowConstraints(35));
                        inputArray[i][j].setMinWidth(35);
                        inputArray[i][j].setMinHeight(35);
                    }
                }
            }
        });
        columnInput.setValueFactory(columnSpinnerValueFactory);
        columnInput.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = inputGrid.getChildren().size();
                inputGrid.getChildren().remove(0, x);
                column = Integer.parseInt(newValue);
                inputArray = new TextField[row][column];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        inputArray[i][j] = new TextField();
                        inputArray[i][j].setAlignment(Pos.CENTER);
                        inputArray[i][j].setPromptText("a" + i + "" + j);
                        inputGrid.add(inputArray[i][j], j, i);
                        inputGrid.getColumnConstraints().add(j, new ColumnConstraints(35));
                        inputGrid.getRowConstraints().add(j, new RowConstraints(35));
                        inputArray[i][j].setMinWidth(35);
                        inputArray[i][j].setMinHeight(35);
                    }
                }
            }
        });
        if (k == 1) {
            button.setText("Transpose");
            button.setOnAction(event -> {
                double[][] transpose = getTranspose(getDouble(inputArray), row, column);
                if (!checker) {
                    resultArray = new TextField[column][row];
                    setOutput(transpose);
                }
                else checker = false;
            });
        } else if (k == 2) {
            columnInput.setValueFactory(rowSpinnerValueFactory);
            button.setText("Cofactor");
            button.setOnAction(event -> {
                DeterminantController.readInput(row, column, inputArray, message);
                double[][] cofactor = cofactor(getDouble(inputArray), row, column);
                if (!checker) {
                    resultArray = new TextField[row][column];
                    setOutput(cofactor);
                }
                else checker = false;
            });
        } else if (k == 3) {
            columnInput.setValueFactory(rowSpinnerValueFactory);
            button.setText("Adjoint");
            button.setOnAction(event -> {
                DeterminantController.readInput(row, column, inputArray, message);
                double[][] adjoint = adjoint(getDouble(inputArray), row, column);
                if (!checker) {
                    resultArray = new TextField[row][column];
                    setOutput(adjoint);
                }
                else checker = false;
            });
        } else if (k == 4) {
            columnInput.setValueFactory(rowSpinnerValueFactory);
            button.setText("Inverse");
            button.setOnAction(event -> {
                DeterminantController.readInput(row, column, inputArray, message);
                double[][] inverse = inverse(getDouble(inputArray), row, column);
                if (!checker) {
                    resultArray = new TextField[row][column];
                    setOutput(inverse);
                }
                else checker = false;

            });
        }
    }

    public static Parent load(int i) {
        Parent parent = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(OthersController.class.getResource("others.fxml"));
            parent = fxmlLoader.load();
            OthersController othersController = fxmlLoader.getController();
            othersController.setUp(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public static double[][] inverse(double[][] matrix, int row, int column) {
        double[][] inverse;
        inverse = adjoint(matrix, row, column);
        double determinant = DeterminantController.getDeterminant(matrix);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                inverse[i][j] /= determinant;
            }
        }
        return inverse;
    }

    public static double[][] adjoint(double[][] matrix, int row, int column) {
        double[][] adjoint;
        adjoint = getTranspose(cofactor(matrix, row, column), row, column);
        return adjoint;
    }

    public static double[][] cofactor(double[][] matrix, int row, int column) {
        double[][] cofactor = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                cofactor[i][j] = Math.pow(-1, i + j) * DeterminantController.getDeterminant(DeterminantController.getSubMatricesOf(i, j, matrix, matrix.length - 1));
            }
        }
        return cofactor;
    }

    public static double[][] getTranspose(double[][] matrix, int row, int column) {
        double[][] transpose = new double[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    public double[][] getDouble(TextField[][] textFields) {
        double[][] result = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                try {
                    result[i][j] = Double.parseDouble(textFields[i][j].getText());
                } catch (NumberFormatException e) {
                    message.setText("Please fill out all the cells");
                    checker = true;
                }
            }
        }
        return result;
    }

    public void setOutput(double[][] result) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                resultArray[i][j] = new TextField();
                resultArray[i][j].setText(Double.toString(result[i][j]));
                inputArray[i][j].setAlignment(Pos.CENTER);
                outputGrid.getColumnConstraints().add(j, new ColumnConstraints(35));
                outputGrid.getRowConstraints().add(j, new RowConstraints(35));
                resultArray[i][j].setMinWidth(35);
                resultArray[i][j].setMinHeight(35);
                outputGrid.add(resultArray[i][j], j, i);
            }
        }
    }

}
