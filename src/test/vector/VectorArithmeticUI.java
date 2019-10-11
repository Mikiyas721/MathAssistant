package test.vector;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VectorArithmeticUI {
    public Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
            //BorderPane borderPane = new BorderPane();
            Parent borderPane = VectorArithmeticController.load();
            Scene scene = new Scene(borderPane, 550, 350);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    };
}
