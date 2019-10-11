package test.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScientificCalculator {
    public Application getApplication() {
        return application;
    }

    private Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("Scientific.fxml"));
            primaryStage.setTitle("Scientific Calculator");
            Scene scene = new Scene(root, 300, 275);
            scene.getStylesheets().add(getClass().getResource("wow.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    };

}
