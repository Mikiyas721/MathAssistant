package test.menu;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import test.calculator.ScientificCalculator;
import test.calculator.StandardCalculator;
import test.converters.ConvertersUI;
import test.matrix.DeterminantController;
import test.matrix.ArithmeticUI;
import test.matrix.OthersUI;
import test.vector.VectorArithmeticController;
import test.vector.VectorArithmeticUI;
import test.vector.VectorOthersUI;

import java.util.Arrays;


public class MenuUI extends Application {
    @FXML
    private Button converters;


    @Override
    public void start(Stage primaryStage) throws Exception {
        ScrollPane scrollPane = new ScrollPane();
        FlowPane flowPane = new FlowPane();
        flowPane.prefWidthProperty().bind(scrollPane.widthProperty());
        scrollPane.setContent(flowPane);
        flowPane.setPadding(new Insets(15, 15, 15, 15));
        flowPane.setHgap(15);
        flowPane.setVgap(15);

        Arrays.asList(
                new MenuCard("Resource\\converter.png", "Converters", Arrays.asList(
                        new Menu("Resource\\height.png", "Length", event -> {
                            new ConvertersUI().identify(1);
                        }),
                        new Menu("Resource\\weight.png", "Weight", event -> {
                            new ConvertersUI().identify(2);
                        }),
                        new Menu("Resource\\temperature.jpg", "Temperature", event -> {
                            new ConvertersUI().identify(3);
                        }),
                        new Menu("Resource\\Volume.png", "Volume", event -> {
                            new ConvertersUI().identify(4);
                        }),
                        new Menu("Resource\\Energy.jpg", "Energy", event -> {
                            new ConvertersUI().identify(5);
                        }),
                        new Menu("Resource\\time.png", "Time", event -> {
                            new ConvertersUI().identify(6);
                        }),
                        new Menu("Resource\\pressure.png", "Pressure", event -> {
                            new ConvertersUI().identify(7);
                        }),
                        new Menu("Resource\\angle.png", "Angle", event -> {
                            new ConvertersUI().identify(8);
                        }),
                        new Menu("Resource\\power.png", "Power", event -> {
                            new ConvertersUI().identify(9);
                        }),
                        new Menu("Resource\\binary.png", "Binary", event -> {
                            new ConvertersUI().identify(10);
                        })

                )),
                new MenuCard("Resource\\Matrix.jpg", "Matrix", Arrays.asList(
                        new Menu("Resource\\arithmetic.png", "Arithmetic Operation", event -> {
                            try {
                                new ArithmeticUI().getApplication().start(new Stage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }),
                        new Menu("Resource\\determinant.png", "Determinant", event -> {
                            DeterminantController.showUI();
                        }),
                        new Menu("Resource\\Transpose.png", "Transpose", event -> {
                            new OthersUI().identify(1);
                        }),
                        new Menu("Resource\\co-factor.png", "Cofactor", event -> {
                            new OthersUI().identify(2);
                        }),
                        new Menu("Resource\\determinant.png", "Adjoint", event -> {
                            new OthersUI().identify(3);
                        }),
                        new Menu("Resource\\inverse.png", "Inverse", event -> {
                            new OthersUI().identify(4);
                        })

                )),
                new MenuCard("Resource\\calculator.png", "Calculator", Arrays.asList(
                        new Menu("Resource\\standard.png", "Standard", event -> {
                            try {
                                new StandardCalculator().getApplication().start(new Stage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }),
                        new Menu("Resource\\scientific.png", "Scientific", event -> {
                            try {
                                new ScientificCalculator().getApplication().start(new Stage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        })

                )),
                new MenuCard("Resource\\vector.png", "Vector", Arrays.asList(
                        new Menu("Resource\\arithmetic2.png", "Arithmetic operation", event -> {
                            try {
                                new VectorArithmeticUI().application.start(new Stage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }),
                        new Menu("Resource\\vector.png", "Unit Vector", event -> {
                            new VectorOthersUI().identify(1);
                        }),
                        new Menu("Resource\\magnitude.png", "Magnitude", event -> {
                            new VectorOthersUI().identify(2);
                        }),
                        new Menu("Resource\\magnitude.png", "Angle", event -> {
                                new VectorOthersUI().identify(3);

                        })
                ))).stream().map(menuCard -> MenuCardController.load(menuCard)).forEach(parent -> flowPane.getChildren().add(parent));


        Scene scene = new Scene(scrollPane, 900, 500);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Math Assistant");
        primaryStage.getIcons().add(new Image(getClass().getResource("Resource/arithmetic.png").toExternalForm()));
        primaryStage.show();
    }


}
