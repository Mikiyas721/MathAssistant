package test;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HeightConverter {
    public HeightConverter(){
        try {
            application.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
           //Centimeter to feet/inch
            Label centimeter = new Label("Centimeter");
            Label feet = new Label("Feet");
            Label inch = new Label("Inch");
            Label message = new Label();
            message.setPadding(new Insets(0, 10, 100, 100));

            TextField feetoutput = new TextField();
            feetoutput.setMaxWidth(80);

            TextField inchoutput = new TextField();
            inchoutput.setMaxWidth(80);

            TextField centimeterinput = new TextField();
            centimeterinput.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    message.setText("");
                    if (newValue.isEmpty()) {
                        feetoutput.setText("");
                        inchoutput.setText("");
                    } else {
                        try {
                            double input = Double.parseDouble(newValue);
                            inchoutput.setText(String.valueOf((input % 30.48) / 2.54).substring(0,4));
                            feetoutput.setText(String.valueOf((input - input % 30.48) / 30.48));

                        } catch (NumberFormatException n) {
                            message.setText("Insert only numbers");
                        }
                    }
                }
            });
            centimeterinput.setMaxWidth(100);

            HBox input = new HBox(20);
            input.getChildren().addAll(centimeter, centimeterinput);
            input.setPadding(new Insets(20, 10, 10, 80));

            HBox output = new HBox(20);
            output.getChildren().addAll(feet, feetoutput, inch, inchoutput);
            output.setPadding(new Insets(20, 10, 10, 20));

            //feet/inch to centimeter

            VBox vBox = new VBox(10);
            vBox.getChildren().addAll(input, output, message);

            Scene scene = new Scene(vBox, 300, 400);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Height Converter");
            primaryStage.show();
        }
    };

}
