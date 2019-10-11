package test.vector;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VectorOthersUI {
    private int identify;
    private Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent borderPane = VectorOtherController.load(identify);
            Scene scene = new Scene(borderPane, 400, 350);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    };

    public void identify(int i) {
        identify = i;
        try {
            application.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
