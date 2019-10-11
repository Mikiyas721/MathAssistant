package test.matrix;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

public class ArithmeticUI {
    private Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent parent = ArithmeticController.setMatrix(Arrays.asList("+","-","*"));
            Scene scene = new Scene(parent,500,600);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Arithmetic Operation");
            primaryStage.show();


        }
    };
    public Application getApplication() {
        return application;
    }

}
