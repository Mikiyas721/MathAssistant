package test.matrix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OthersUI {
    private Parent parent;
    public Application getApplication() {
        return application;
    }

    private Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
            BorderPane borderPane = new BorderPane();

            borderPane.setCenter(parent);
            Scene scene = new Scene(borderPane, 600, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    };
    public void identify(int i) {
        parent = OthersController.load(i);
        try {
            application.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
