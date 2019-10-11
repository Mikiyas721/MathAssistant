package test.converters;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class ConvertersUI {
    private Parent parent;
    private Converters converters;
    public Application application = new Application() {
        @Override
        public void start(Stage primaryStage) throws Exception {
            BorderPane borderPane = new BorderPane();

            borderPane.setCenter(parent);
            Scene scene = new Scene(borderPane, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle(converters.getName() + " Converter");
            primaryStage.showAndWait();
        }
    };

    public void identify(int i) {
        if (i == 1) {
            converters = new Converters("Length", Arrays.asList(
                    new Unit("Nanometers", 1 * Math.pow(10, -9)), new Unit("Micrometers", Math.pow(10, -6)), new Unit("Millimeters", Math.pow(10, -3)), new Unit("Centimeters", Math.pow(10, -2)), new Unit("Meters", Math.pow(10, 0)), new Unit("KiloMeters", Math.pow(10, 3)), new Unit("Inches", 0.0254), new Unit("Feet", 0.305), new Unit("Yards", 0.914), new Unit("Miles", 1609.344), new Unit("Nautical Miles", 1852)),
                    Arrays.asList(new Unit("Nanometers", 1 * Math.pow(10, -7)), new Unit("Micrometers", Math.pow(10, -6)), new Unit("Millimeters", Math.pow(10, -3)), new Unit("Centimeters", Math.pow(10, -2)), new Unit("Meters", Math.pow(10, 0)), new Unit("KiloMeters", Math.pow(10, 3)), new Unit("Inches", 0.0254), new Unit("Feet", 0.305), new Unit("Yards", 0.914), new Unit("Miles", 1609.344), new Unit("Nautical Miles", 1852)));
            parent = ConvertersController.load(converters);

        } else if (i == 2) {
            converters = new Converters("Weight", Arrays.asList(
                    new Unit("Carats", 0.2), new Unit("Milligrams", 0.001), new Unit("Centigrams", 0.01), new Unit("Decigrams", 0.1), new Unit("Grams", 1), new Unit("Dekagrams", 10), new Unit("Hectograms", 100), new Unit("Kilograms", 1000), new Unit("Metric tonnes", Math.pow(10, 6)), new Unit("Ounces", 28.35), new Unit("Pounds", 453.592), new Unit("Stone", 6350.293), new Unit("Ton", 907184.74)),
                    Arrays.asList(new Unit("Carats", 0.2), new Unit("Milligrams", 0.001), new Unit("Centigrams", 0.01), new Unit("Decigrams", 0.1), new Unit("Grams", 1), new Unit("Dekagrams", 10), new Unit("Hectograms", 100), new Unit("Kilograms", 1000), new Unit("Metric tonnes", Math.pow(10, 6)), new Unit("Ounces", 28.35), new Unit("Pounds", 453.592), new Unit("Stone", 6350.293), new Unit("Ton", 907184.74)));
            parent = ConvertersController.load(converters);
        } else if (i == 3) {
            converters = new Converters("Temperature", Arrays.asList(
                    new Unit("Celsius", 273.15), new Unit("Fahrenheit", 1), new Unit("Kelvin", 1)),
                    Arrays.asList(new Unit("Celsius", 273.15), new Unit("Fahrenheit", 1), new Unit("Kelvin", 1)));
            parent = ConvertersController.load(converters);
        } else if (i == 4) {
            converters = new Converters("Volume", Arrays.asList(
                    new Unit("Milliliters", Math.pow(10, -6)), new Unit("Cubic centimeters", Math.pow(10, -6)), new Unit("Liters", Math.pow(10, -3)), new Unit("Cubic meters", 1), new Unit("Gallons", 0.00379), new Unit("Cubic inches", 1.639 * Math.pow(10, -5)), new Unit("Cubic inches", 1.639 * Math.pow(10, -5)), new Unit("Cubic feet", 0.0283), new Unit("Cubic yards", 0.765)),
                    Arrays.asList(new Unit("Milliliters", Math.pow(10, -6)), new Unit("Cubic centimeters", Math.pow(10, -6)), new Unit("Liters", Math.pow(10, -3)), new Unit("Cubic meters", 1), new Unit("Gallons", 0.00379), new Unit("Cubic inches", 1.639 * Math.pow(10, -5)), new Unit("Cubic inches", 1.639 * Math.pow(10, -5)), new Unit("Cubic feet", 0.0283), new Unit("Cubic yards", 0.765)));
            parent = ConvertersController.load(converters);
        } else if (i == 5) {
            converters = new Converters("Energy", Arrays.asList(
                    new Unit("Electron Volts", 1.602 * Math.pow(10, -19)), new Unit("Joules", 1), new Unit("Kilojoules", Math.pow(10, 3)), new Unit("Food calories", 4.182)),
                    Arrays.asList(new Unit("Electron Volts", 1.602 * Math.pow(10, -19)), new Unit("Joules", 1), new Unit("Kilojoules", Math.pow(10, 3)), new Unit("Food calories", 4.182)));
            parent = ConvertersController.load(converters);
        } else if (i == 6) {
            converters = new Converters("Time", Arrays.asList(
                    new Unit("Microseconds", Math.pow(10, -6)), new Unit("Milliseconds", Math.pow(10, -3)), new Unit("Seconds", 1), new Unit("Minutes", 60), new Unit("Hours", 3600), new Unit("Days", 86400), new Unit("Weeks", 604800), new Unit("Years", 31536000)),
                    Arrays.asList(new Unit("Microseconds", Math.pow(10, -6)), new Unit("Milliseconds", Math.pow(10, -3)), new Unit("Seconds", 1), new Unit("Minutes", 60), new Unit("Hours", 3600), new Unit("Days", 86400), new Unit("Weeks", 604800), new Unit("Years", 31536000)));
            parent = ConvertersController.load(converters);
        } else if (i == 7) {
            converters = new Converters("Pressure", Arrays.asList(
                    new Unit("Atmospheres", 101325), new Unit("Bars", Math.pow(10, 5)), new Unit("Kilopascals", Math.pow(10, 6)), new Unit("Millimeters of mercury", 133.3), new Unit("Pascals", 1), new Unit("Pounds per square inch", 6894.757)),
                    Arrays.asList(new Unit("Atmospheres", 101325), new Unit("Bars", Math.pow(10, 5)), new Unit("Kilopascals", Math.pow(10, 6)), new Unit("Millimeters of mercury", 133.3), new Unit("Pascals", 1), new Unit("Pounds per square inch", 6894.757)));
            parent = ConvertersController.load(converters);
        } else if (i == 8) {
            converters = new Converters("Angle", Arrays.asList(
                    new Unit("Degrees",0.0175),new Unit( "Radians",1),new Unit( "Gradians",0.0157)),
                    Arrays.asList(new Unit("Degrees",0.0175),new Unit( "Radians",1),new Unit( "Gradians",0.0157)));
            parent = ConvertersController.load(converters);
        }
        else if (i == 9) {
            converters = new Converters("Power", Arrays.asList(
                    new Unit("Watts",1),new Unit( "Kilowatts",Math.pow(10,3)),new Unit( "Horsepower",745.7),new Unit(  "BTUs per Minute",17.5439)),
                    Arrays.asList(new Unit("Watts",1),new Unit( "Kilowatts",Math.pow(10,3)),new Unit( "Horsepower",745.7),new Unit(  "BTUs per Minute",17.5439)));
            parent = ConvertersController.load(converters);

        } else if (i == 10) {
            converters = new Converters("Binary", Arrays.asList(
                    new Unit("Bits",1),new Unit("Bytes",8) ,new Unit( "Kilobytes",8000),new Unit(  "Megabytes",8*Math.pow(10,6)),new Unit(  "Gigabytes",8*Math.pow(10,9)),new Unit(   "Terabytes",8*Math.pow(10,12))),
                    Arrays.asList(new Unit("Bits",1),new Unit("Bytes",8) ,new Unit( "Kilobytes",8000),new Unit(  "Megabytes",8*Math.pow(10,6)),new Unit(  "Gigabytes",8*Math.pow(10,9)),new Unit(   "Terabytes",8*Math.pow(10,12))));
            parent = ConvertersController.load(converters);
        }

        try {
            application.start(new Stage());
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}

