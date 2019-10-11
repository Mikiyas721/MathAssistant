package test.converters;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.io.IOException;

public class ConvertersController {
    @FXML
    private ComboBox<Unit> from;
    @FXML
    private ComboBox<Unit> to;
    @FXML
    private Label name;
    @FXML
    private TextField fromInput;
    @FXML
    private TextField toDisplay;
    @FXML
    private Label message;

    public void setConverter(Converters converters) {
        name.setText(converters.getName());
        from.getItems().addAll(converters.getFrom());
        from.setConverter(new StringConverter<Unit>() {
            @Override
            public String toString(Unit object) {
                return object.getName();
            }

            @Override
            public Unit fromString(String string) {
                return null;
            }
        });
        from.setPromptText(converters.getFromNames().get(0));
        from.getSelectionModel().selectFirst();
        from.valueProperty().addListener(new ChangeListener<Unit>() {
            @Override
            public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) {
                if (fromInput.getText().isEmpty()) {
                } else
                    toDisplay.setText(Double.toString((Double.parseDouble(fromInput.getText()) * newValue.getValue()) / to.getValue().getValue()));
            }
        });
        to.getItems().addAll(converters.getTo());
        to.setConverter(new StringConverter<Unit>() {
            @Override
            public String toString(Unit object) {
                return object.getName();
            }

            @Override
            public Unit fromString(String string) {
                return null;
            }
        });
        to.setPromptText(converters.getToNames().get(0));
        to.getSelectionModel().selectLast();
        to.valueProperty().addListener(new ChangeListener<Unit>() {
            @Override
            public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) {
                if (fromInput.getText().isEmpty()) {
                } else
                    toDisplay.setText(Double.toString((Double.parseDouble(fromInput.getText()) * from.getValue().getValue()) / newValue.getValue()));
            }
        });
        fromInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (from.getValue() == null || to.getValue() == null) {
                        message.setText("Choose the units of conversion first");
                    } else {
                        message.setText("");
                        if (newValue.isEmpty()) toDisplay.setText("");
                        else
                            evaluateResult(Double.parseDouble(newValue));
                    }
                } catch (NumberFormatException e) {
                    message.setText("Only numbers");
                }
            }
        });
    }

    public static Parent load(Converters converters) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ConvertersController.class.getResource("converters.fxml"));
            Parent parent = fxmlLoader.load();
            ConvertersController convertersController = fxmlLoader.getController();
            convertersController.setConverter(converters);
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void evaluateResult(double newValue) {
        if (name.getText() == "Temperature") {
            if (from.getValue().getName() == "Celsius" && to.getValue().getName() == "Kelvin") {
                toDisplay.setText(Double.toString(Double.parseDouble(fromInput.getText()) + 273));
            } else if (from.getValue().getName() == "Kelvin" && to.getValue().getName() == "Celsius") {
                toDisplay.setText(Double.toString(Double.parseDouble(fromInput.getText()) - 273));
            } else if (from.getValue().getName() == "Celsius" && to.getValue().getName() == "Fahrenheit") {
                toDisplay.setText(Double.toString(((9 / 5.0) * Double.parseDouble(fromInput.getText())) + 32));
            } else if (from.getValue().getName() == "Fahrenheit" && to.getValue().getName() == "Celsius") {
                toDisplay.setText(Double.toString((5 / 9.0) * (Double.parseDouble(fromInput.getText()) - 32)));
            } else if (from.getValue().getName() == "Fahrenheit" && to.getValue().getName() == "Kelvin") {
                toDisplay.setText(Double.toString((5 / 9.0) * (Double.parseDouble(fromInput.getText()) - 32) + 273));
            } else if (from.getValue().getName() == "Kelvin" && to.getValue().getName() == "Fahrenheit") {
                toDisplay.setText(Double.toString((9 / 5.0) * (Double.parseDouble(fromInput.getText()) - 273) + 32));
            }
        } else {
            toDisplay.setText(Double.toString((newValue * from.getValue().getValue()) / to.getValue().getValue()));
        }
    }


}
