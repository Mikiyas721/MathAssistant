package test.matrix;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DeterminantController implements Initializable {
    @FXML
    private GridPane input;
    @FXML
    private Spinner<Integer> rowInput;
    @FXML
    private Spinner<Integer> columnInput;
    @FXML
    private Button calculate;
    @FXML
    private Label resultDisplay;
    @FXML
    private Label message;
    private int row = 2;
    private int column = 2;
    private TextField textFieldArray[][];

    public void setup() {
        textFieldArray = new TextField[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                setUpGrid(i, j);
            }
        }
        SpinnerValueFactory.IntegerSpinnerValueFactory SpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100);


        rowInput.setValueFactory(SpinnerValueFactory);
        rowInput.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = input.getChildren().size();
                input.getChildren().remove(0, x);
                row = Integer.parseInt(newValue);
                column = Integer.parseInt(newValue);
                if (row > 50) message.setText("Limit reached");
                else {
                    message.setText("");
                    textFieldArray = new TextField[row][column];
                    for (int i = 0; i < Integer.parseInt(newValue); i++) {
                        for (int j = 0; j < column; j++) {
                            setUpGrid(i, j);
                        }
                    }

                }
            }
        });
        columnInput.setValueFactory(SpinnerValueFactory);
        columnInput.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int x = input.getChildren().size();
                input.getChildren().remove(0, x);
                column = Integer.parseInt(newValue);
                row = Integer.parseInt(newValue);
                if (row > 50) message.setText("Limit reached");
                else {
                    message.setText("");
                    textFieldArray = new TextField[row][column];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                            setUpGrid(i, j);
                        }
                    }
                }
            }
        });
        calculate.setOnAction(event -> {
            double determinant = getDeterminant(readInput(row, column, textFieldArray, message));
            resultDisplay.setText(Double.toString(determinant));
        });
    }

    public static double[][] readInput(int row, int column, TextField[][] textFieldArray, Label message) {
        double input[][] = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                try {
                    input[i][j] = Double.parseDouble(textFieldArray[i][j].getText());
                } catch (NumberFormatException e) {
                    message.setText("Please fill all the cells");
                }
            }
        }
        return input;
    }

    public static double getDeterminant(double input[][]) {

        if (input.length == 2) {
            return input[0][0] * input[1][1] - input[0][1] * input[1][0];
        } else {
            double sum = 0;
            for (int i = 0; i < input.length; ++i) {
                sum += input[i][0] * Math.pow(-1, (double) i) * getDeterminant(getSubMatricesOf(i, 0, input, input.length - 1));
            }
            return sum;
        }
    }

    public static double[][] getSubMatricesOf(int row, int column, double input[][], int lenght) {
        double[][] m = new double[lenght][lenght];
        int i = 0;

        for (int n = 0; i < input.length; ++i) {
            if (i != row) {
                int j = 0;
                for (int k = 0; j < input.length; ++j) {
                    if (j != column) {
                        m[n][k] = input[i][j];
                        ++k;
                    }
                }
                ++n;
            }
        }
        return m;
    }

    public void setUpGrid(int i, int j) {
        textFieldArray[i][j] = new TextField();
        textFieldArray[i][j].getStylesheets().add(getClass().getResource("textfield.css").toExternalForm());
        textFieldArray[i][j].setMinWidth(35);
        textFieldArray[i][j].setMinHeight(35);
        textFieldArray[i][j].setPromptText("a" + i + "" + j);
        textFieldArray[i][j].setAlignment(Pos.CENTER);
        input.add(textFieldArray[i][j], j, i);
        input.getColumnConstraints().add(j, new ColumnConstraints(35));
        input.getRowConstraints().add(j, new RowConstraints(35));
    }

    public static void showUI() {
        try {
            new Application() {
                @Override
                public void start(Stage primaryStage) throws Exception {
                    FXMLLoader loader = new FXMLLoader(ArithmeticController.class.getResource("determinant.fxml"));
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent, 500, 400);
                    primaryStage.setTitle("Determinant");

                    primaryStage.setScene(scene);
                    primaryStage.show();

                }
            }.start(new Stage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setup();
    }
}
