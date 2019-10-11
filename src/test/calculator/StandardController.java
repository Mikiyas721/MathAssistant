package test.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;


public class StandardController {

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private Button sum;
    @FXML
    private Button product;
    @FXML
    private Button quotient;
    @FXML
    private Button difference;
    @FXML
    private Button equals;
    @FXML
    private Button clear;
    @FXML
    private Button cancel;
    @FXML
    private Button dot;
    @FXML
    private Button minus;
    @FXML
    private Button parenthesis;
    @FXML
    private TextField display;

    private double fnumber;
    private double snumber;
    private int operation;
    private int lenght;

    private ScientificController scientificController = new ScientificController();

    public void numberPrinter(ActionEvent actionEvent) {
        if (actionEvent.getSource() == one) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("1");
            } else
                display.setText(display.getText() + 1);
        } else if (actionEvent.getSource() == two) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("2");
            } else
                display.setText(display.getText() + 2);
        } else if (actionEvent.getSource() == three) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("3");
            } else
                display.setText(display.getText() + 3);
        } else if (actionEvent.getSource() == four) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("4");
            } else
                display.setText(display.getText() + 4);
        } else if (actionEvent.getSource() == five) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("5");
            } else
                display.setText(display.getText() + 5);
        } else if (actionEvent.getSource() == six) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("6");
            } else
                display.setText(display.getText() + 6);
        } else if (actionEvent.getSource() == seven) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("7");
            } else
                display.setText(display.getText() + 7);
        } else if (actionEvent.getSource() == eight) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("8");
            } else
                display.setText(display.getText() + 8);
        } else if (actionEvent.getSource() == nine) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("9");
            } else
                display.setText(display.getText() + 9);
        } else if (actionEvent.getSource() == zero) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("0");
            } else
                display.setText(display.getText() + 0);
        }

    }
    public void printDot(ActionEvent actionEvent){
        String input = display.getText();
        int lenght = input.length();
        boolean check = true;
        for (int i=0;i<lenght;i++){
            if (input.charAt(i)=='.') check = false;
        }
        if (check) display.setText(display.getText()+'.');
    }

    public void operation(ActionEvent actionEvent) {
        if (actionEvent.getSource() == sum) {

            fnumber = Double.parseDouble(display.getText());
            operation = 1;
            display.setText("+");
        } else if (actionEvent.getSource() == difference) {

            fnumber = Double.parseDouble(display.getText());
            operation = 2;
            display.setText("-");
        } else if (actionEvent.getSource() == product) {

            fnumber = Double.parseDouble(display.getText());
            operation = 3;
            display.setText("×");

        } else if (actionEvent.getSource() == quotient) {

            fnumber = Double.parseDouble(display.getText());
            operation = 4;
            display.setText("÷");
        } else if (actionEvent.getSource() == cancel) {

            String string = display.getText();
            String cleared = string.substring(0, display.getText().length() - 1);
            display.setText(cleared);

        } else if (actionEvent.getSource() == clear) {

            display.setText("0");
            fnumber = 0;
            snumber = 0;
            operation = 0;

        } else if (actionEvent.getSource() == equals) {
            if (operation == 1) {
                snumber = Double.parseDouble(display.getText());
                display.setText(Double.toString(fnumber + snumber));
            } else if (operation == 2) {
                snumber = Double.parseDouble(display.getText());
                display.setText(Double.toString(fnumber - snumber));
            } else if (operation == 3) {
                snumber = Double.parseDouble(display.getText());
                display.setText(Double.toString(fnumber * snumber));
            } else if (operation == 4) {
                snumber = Double.parseDouble(display.getText());
                if (snumber == 0) {
                    display.setText("Math Error");
                } else
                    display.setText(Double.toString(fnumber / snumber));
            }

            fnumber = 0;
            snumber = 0;
            operation = 0;
            lenght = 0;

        }
    }
}
