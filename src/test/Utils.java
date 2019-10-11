package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import test.matrix.ArithmeticController;

public class Utils {
    private Utils() {
    }

    public static void show(String path) {
        try {
            new Application() {
                @Override
                public void start(Stage primaryStage) throws Exception {
                    FXMLLoader loader = new FXMLLoader(ArithmeticController.class.getResource(path));
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent, 500, 600);
                    System system;
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            }.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
